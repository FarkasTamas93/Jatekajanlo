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
 * a platform játékokat mutató nézet controllere.
 *
 */
public class PlatformJatekViewController {

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
    private CheckBox cupCheckBox;

    @FXML
    private Label cupLabel;

    @FXML
    private CheckBox limboCheckBox;

    @FXML
    private Label limboLabel;

    @FXML
    private CheckBox jazzCheckBox;

    @FXML
    private Label jazzLabel;

    @FXML
    private CheckBox oriCheckBox;

    @FXML
    private Label oriLabel;

    @FXML
    private CheckBox littleCheckBox;

    @FXML
    private Label littleLabel;

    @FXML
    private CheckBox unravelCheckBox;

    @FXML
    private Label unravelLabel;

    @FXML
    private CheckBox acCheckBox;

    @FXML
    private Label acLabel;

    @FXML
    private CheckBox valiantCheckBox;

    @FXML
    private Label valiantLabel;

    @FXML
    private CheckBox badlandCheckBox;

    @FXML
    private Label badlandLabel;

    @FXML
    private CheckBox ibbCheckBox;

    @FXML
    private Label ibbLAbel;

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
        jatekok.put(cupCheckBox,cupLabel);
        jatekok.put(limboCheckBox, limboLabel);
        jatekok.put(jazzCheckBox, jazzLabel);
        jatekok.put(oriCheckBox, oriLabel);
        jatekok.put(littleCheckBox, littleLabel);
        jatekok.put(unravelCheckBox, unravelLabel);
        jatekok.put(acCheckBox, acLabel);
        jatekok.put(valiantCheckBox, valiantLabel);
        jatekok.put(badlandCheckBox, badlandLabel);
        jatekok.put(ibbCheckBox, ibbLAbel);
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
