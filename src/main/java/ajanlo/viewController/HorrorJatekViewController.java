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
public class HorrorJatekViewController {

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
    private CheckBox dbdCheckBox;

    @FXML
    private Label dbdLabel;

    @FXML
    private CheckBox outlastCheckBox;

    @FXML
    private Label outlastLabel;

    @FXML
    private CheckBox slenderCheckBox;

    @FXML
    private Label slenderLAbel;

    @FXML
    private CheckBox fnafCheckBox;

    @FXML
    private Label fnafLabel;

    @FXML
    private CheckBox silentCheckBox;

    @FXML
    private Label silentLabel;

    @FXML
    private CheckBox dlCheckBox;

    @FXML
    private Label dlLabel;

    @FXML
    private CheckBox evilCheckBox;

    @FXML
    private Label evilLabel;

    @FXML
    private CheckBox alienCheckBox;

    @FXML
    private Label alienLabel;

    @FXML
    private CheckBox penumbraCheckBox;

    @FXML
    private Label penumbraLabel;

    @FXML
    private CheckBox reCheckBox;

    @FXML
    private Label reLabel;

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
        jatekok.put(dbdCheckBox,dbdLabel);
        jatekok.put(outlastCheckBox, outlastLabel);
        jatekok.put(slenderCheckBox, slenderLAbel);
        jatekok.put(fnafCheckBox, fnafLabel);
        jatekok.put(silentCheckBox, silentLabel);
        jatekok.put(dlCheckBox, dlLabel);
        jatekok.put(evilCheckBox, evilLabel);
        jatekok.put(alienCheckBox, alienLabel);
        jatekok.put(penumbraCheckBox, penumbraLabel);
        jatekok.put(reCheckBox, reLabel);
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
