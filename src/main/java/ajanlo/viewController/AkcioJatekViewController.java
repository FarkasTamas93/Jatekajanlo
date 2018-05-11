package ajanlo.viewController;

import ajanlo.JpaService;
import ajanlo.KivalasztottJatekokService;
import ajanlo.Main;
import ajanlo.model.Jatekvalasztas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */

/**
 * az akció játékokat mutató nézet controllere.
 *
 */
public class AkcioJatekViewController {

    Map<CheckBox, Label> jatekok = new HashMap<>();
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
    private CheckBox bf1CheckBox;

    @FXML
    private Label bf1Label;

    @FXML
    private CheckBox owCheckBox;

    @FXML
    private Label owLabel;

    @FXML
    private CheckBox doomCheckBox;

    @FXML
    private Label doomLabel;

    @FXML
    private CheckBox bf2CheckBox;

    @FXML
    private Label bf2Label;

    @FXML
    private CheckBox codCheckBox;

    @FXML
    private Label codLabel;

    @FXML
    private CheckBox niohCheckBox;

    @FXML
    private Label niohLabel;

    @FXML
    private CheckBox somCheckBox;

    @FXML
    private Label somLabel;

    @FXML
    private CheckBox destinyCheckBox;

    @FXML
    private Label destinyLabel;

    @FXML
    private CheckBox injusticeCheckBox;

    @FXML
    private Label injusticeLabel;

    @FXML
    private CheckBox wolfCheckBox;

    @FXML
    private Label wolfeinsteinLabel;

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
        jatekok.put(bf1CheckBox, bf1Label);
        jatekok.put(owCheckBox, owLabel);
        jatekok.put(doomCheckBox, doomLabel);
        jatekok.put(bf2CheckBox, bf2Label);
        jatekok.put(codCheckBox, codLabel);
        jatekok.put(niohCheckBox, niohLabel);
        jatekok.put(somCheckBox, somLabel);
        jatekok.put(destinyCheckBox, destinyLabel);
        jatekok.put(injusticeCheckBox, injusticeLabel);
        jatekok.put(wolfCheckBox, wolfeinsteinLabel);
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
