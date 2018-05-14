package ajanlo.viewController;

import ajanlo.JpaService;
import ajanlo.KivalasztottJatekokService;
import ajanlo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.*;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */
/**
 * a szimulátor játékokat mutató nézet controllere.
 *
 */
public class SzimulatorJatekViewController {

    Map<CheckBox,Label> jatekok = new HashMap<>();
    ArrayList<Label> labelList = new ArrayList<>();

    @FXML
    private void initialize() {
        int felvettJatekokSzama = KivalasztottJatekokService.getInstance().getJatekNevek().size();
        KiiratasController.getInstance().labelArrayInit(labelList, elsoKivalasztott, masodikKivalasztott, harmadikKivalasztott, negyedikKivalasztott, otodikKivalasztott);
        jatekInit();
        KiiratasController.getInstance().kivalasztottJatekokKiiratasa(felvettJatekokSzama, labelList);
        KiiratasController.getInstance().bepipalas(felvettJatekokSzama, jatekok);
    }

    @FXML
    private CheckBox nfsCheckBox;

    @FXML
    private Label nfsLabel;

    @FXML
    private CheckBox goatCheckBox;

    @FXML
    private Label goatLabel;

    @FXML
    private CheckBox fifaCheckBox;

    @FXML
    private Label fifaLabel;

    @FXML
    private CheckBox rocketCheckBox;

    @FXML
    private Label rocketLabel;

    @FXML
    private CheckBox motocrossCheckBox;

    @FXML
    private Label motocrossLabel;

    @FXML
    private CheckBox tankCheckBox;

    @FXML
    private Label tankLabel;

    @FXML
    private CheckBox truckCheckBox;

    @FXML
    private Label truckLabel;

    @FXML
    private CheckBox pesCheckBox;

    @FXML
    private Label pesLAbel;

    @FXML
    private CheckBox paradiseCheckBox;

    @FXML
    private Label paradiseLAbel;

    @FXML
    private CheckBox colinCheckBox;

    @FXML
    private Label colinLabel;

    @FXML
    private Label elsoKivalasztott;

    @FXML
    private Label masodikKivalasztott;

    @FXML
    private Label harmadikKivalasztott;

    @FXML
    private Label negyedikKivalasztott;

    @FXML
    private Label otodikKivalasztott;

    @FXML
    private Button akcioButton;

    @FXML
    private Button kalandButton;

    @FXML
    private Button horrorButton;

    @FXML
    private Button platformButton;

    @FXML
    private Button szimulatorButton;

    @FXML
    private Button ugyessegiButton;

    @FXML
    private Button szerepjatekButton;

    private Main mainApp;
    /**
     * beállítja a mainAppot.
     *
     * @param mainApp megkapja a mainApp-ot
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private void jatekInit() {
        jatekok.put(nfsCheckBox,nfsLabel);
        jatekok.put(goatCheckBox, goatLabel);
        jatekok.put(fifaCheckBox, fifaLabel);
        jatekok.put(rocketCheckBox, rocketLabel);
        jatekok.put(motocrossCheckBox, motocrossLabel);
        jatekok.put(tankCheckBox, tankLabel);
        jatekok.put(truckCheckBox, truckLabel);
        jatekok.put(pesCheckBox, pesLAbel);
        jatekok.put(paradiseCheckBox, paradiseLAbel);
        jatekok.put(colinCheckBox, colinLabel);
    }

    @FXML
    private void viewValasztas(ActionEvent event) {
        String buttonId = ((Button) event.getSource()).getId();
        ViewValasztasController.getInstance().viewValtas(mainApp, buttonId);
    }

    @FXML
    private void checkboxKivalasztas(ActionEvent event) {
        KiiratasController.getInstance().checkboxKivalasztasKiiratas(event, jatekok, labelList);
    }

    @FXML
    private void showKivalasztottJatekokErtekelese() {
        ViewValasztasController.getInstance().viewValtasErtekeles(mainApp);
    }
}
