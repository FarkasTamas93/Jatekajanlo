package ajanlo.viewController;

import ajanlo.JpaService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import ajanlo.Main;

/**
 *A rootLayout inicializálásáért felel.
 *
 */
public class RootLayoutViewController {

    @FXML
    private MenuBar menuBar;

    private Main mainApp;
    /**
     * beállítja a mainAppot.
     *
     * @param mainApp megkapja a mainApp-ot
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * inicializálja a rootlayoutot.
     *
     */
    @FXML
    private void initialize()
    {
        menuBar.getMenus().get(0).setOnAction(event -> {
            JpaService.getJpaServiceInstance().getEntityManager().close();
            JpaService.getJpaServiceInstance().getEntityManagerFactory().close();
            System.exit(0);
        });

        menuBar.getMenus().get(1).setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Program");
            alert.setHeaderText("A programot keszitette : Farkas Tamas");
            alert.setContentText("Elerhetoseg: \n Hajduszoboszlo 4200 Telefon:0000-0000 Email:valami@email.hu");
            alert.initOwner(mainApp.getPrimaryStage());
            alert.showAndWait();
        });
    }
}
