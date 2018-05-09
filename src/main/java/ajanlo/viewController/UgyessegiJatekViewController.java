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
public class UgyessegiJatekViewController {

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
    private CheckBox superhotCheckBox;

    @FXML
    private Label superhotLabel;

    @FXML
    private CheckBox portalCheckBox;

    @FXML
    private Label portalLabel;

    @FXML
    private CheckBox witnessCheckBox;

    @FXML
    private Label witnessLabel;

    @FXML
    private CheckBox raymanCheckBox;

    @FXML
    private Label raymanLabel;

    @FXML
    private CheckBox pvzCheckBox;

    @FXML
    private Label pvzLabel;

    @FXML
    private CheckBox chickenCheckBox;

    @FXML
    private Label chickenLabel;

    @FXML
    private CheckBox talosCheckBox;

    @FXML
    private Label talosLabel;

    @FXML
    private CheckBox mystCheckBox;

    @FXML
    private Label mystLabel;

    @FXML
    private CheckBox machineCheckBox;

    @FXML
    private Label machineLabel;

    @FXML
    private CheckBox drawnCheckBox;

    @FXML
    private Label drawnLabel;

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

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private void jatekInit() {
        jatekok.put(superhotCheckBox,superhotLabel);
        jatekok.put(portalCheckBox, portalLabel);
        jatekok.put(witnessCheckBox, witnessLabel);
        jatekok.put(raymanCheckBox, raymanLabel);
        jatekok.put(pvzCheckBox, pvzLabel);
        jatekok.put(chickenCheckBox, chickenLabel);
        jatekok.put(talosCheckBox, talosLabel);
        jatekok.put(mystCheckBox, mystLabel);
        jatekok.put(machineCheckBox, machineLabel);
        jatekok.put(drawnCheckBox, drawnLabel);
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
