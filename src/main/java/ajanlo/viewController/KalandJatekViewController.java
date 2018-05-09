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
public class KalandJatekViewController {

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
    private CheckBox lisCheckBox;

    @FXML
    private Label lisLabel;

    @FXML
    private CheckBox trCheckBox;

    @FXML
    private Label trLabel;

    @FXML
    private CheckBox twdCheckBox;

    @FXML
    private Label twdLabel;

    @FXML
    private CheckBox brothersCheckBox;

    @FXML
    private Label brothersLabel;

    @FXML
    private CheckBox zeldaCheckBox;

    @FXML
    private Label zeldaLAbel;

    @FXML
    private CheckBox horizonCheckBox;

    @FXML
    private Label horizonLabel;

    @FXML
    private CheckBox primalCheckBox;

    @FXML
    private Label primalLabel;

    @FXML
    private CheckBox dsCheckBox;

    @FXML
    private Label dsLabel;

    @FXML
    private CheckBox bbCheckBox;

    @FXML
    private Label bbLabel;

    @FXML
    private CheckBox aquariaCheckBox;

    @FXML
    private Label aquariaLabel;

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
        jatekok.put(lisCheckBox,lisLabel);
        jatekok.put(trCheckBox, trLabel);
        jatekok.put(twdCheckBox, twdLabel);
        jatekok.put(brothersCheckBox, brothersLabel);
        jatekok.put(zeldaCheckBox, zeldaLAbel);
        jatekok.put(horizonCheckBox, horizonLabel);
        jatekok.put(primalCheckBox, primalLabel);
        jatekok.put(dsCheckBox, dsLabel);
        jatekok.put(bbCheckBox, bbLabel);
        jatekok.put(aquariaCheckBox, aquariaLabel);
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
