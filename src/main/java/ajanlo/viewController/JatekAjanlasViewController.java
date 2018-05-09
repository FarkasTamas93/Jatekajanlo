package ajanlo.viewController;

import ajanlo.JpaService;
import ajanlo.KlaszterezettJatekokService;
import ajanlo.Main;
import ajanlo.model.Jatekok;
import ajanlo.optimalisKereso.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Map;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */
public class JatekAjanlasViewController {

    private static Logger logger = LoggerFactory.getLogger(JatekAjanlasViewController.class);

    @FXML
    private TextField elkolthetoPenz;

    @FXML
    private TableView<Operator> ajanlasTableView;

    @FXML
    private TableColumn<Operator, String> ajanlasTableViewC1;

    @FXML
    private TableColumn<Operator, Integer> ajanlasTableViewC2;

    @FXML
    private TableColumn<Operator, Double> ajanlasTableViewC3;

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void mapTeszt() {
/*
        Map<String, Double> temp = KlaszterezettJatekokService.getKlaszterezettJatekokService().getJatekokAtlagErtekelese();
        for (Map.Entry k : temp.entrySet()) {
            System.out.println("Jatek neve: " + k.getKey() + "   Jatek atlagertekelese: " + k.getValue());
        }

        JatekokNeveEsAra.getInstance().setJatekok(JpaService.getJpaServiceInstance().getJatekokServiceJPA().getJatekok());

        for (Jatekok k : JatekokNeveEsAra.getInstance().getJatekok()) {
            System.out.println(k.getNev() + "  " + k.getAr());
        }
*/
        if (Integer.parseInt(elkolthetoPenz.getText()) >= 2000 && Integer.parseInt(elkolthetoPenz.getText()) <= 35000) {
            JatekokNeveEsAra.getInstance().setJatekok(JpaService.getJpaServiceInstance().getJatekokServiceJPA().getJatekok());

//            System.out.println("**********************************");

            Problema p = new Problema();
            List<Operator> m = new Optimalis().keres(p, Integer.parseInt(elkolthetoPenz.getText()));

            logger.info("Sikerult jatekot talalni");

            ajanlasTableView.setItems(FXCollections.observableArrayList(m));

            ajanlasTableViewC1.setCellValueFactory(new PropertyValueFactory<Operator, String>("jatekNev"));
            ajanlasTableViewC2.setCellValueFactory(new PropertyValueFactory<Operator, Integer>("jatekAr"));
            ajanlasTableViewC3.setCellValueFactory(new PropertyValueFactory<Operator, Double>("atlag"));

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Nem megfelelo osszeg");
            alert.setContentText("Megadhato penzosszeg 2000-tol 35000-ig");
            alert.showAndWait();
        }
    }

    @FXML
    public void changeKivalasztottJatekokErtekelese(){
        mainApp.showKivalasztottJatekokErtekelese();
    }
}
