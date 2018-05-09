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
public class SzerepJatekViewController {

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
    private CheckBox gw2CheckBox;

    @FXML
    private Label gw2Label;

    @FXML
    private CheckBox wowCheckBox;

    @FXML
    private Label wowLabel;

    @FXML
    private CheckBox sodCheckBox;

    @FXML
    private Label sodLabel;

    @FXML
    private CheckBox ffCheckBox;

    @FXML
    private Label ffLabel;

    @FXML
    private CheckBox starwarsCheckBox;

    @FXML
    private Label starwarsLabel;

    @FXML
    private CheckBox aionCheckBox;

    @FXML
    private Label aionLAbel;

    @FXML
    private CheckBox dungeonCheckBox;

    @FXML
    private Label dungeonLabel;

    @FXML
    private CheckBox auraCheckBox;

    @FXML
    private Label auraLabel;

    @FXML
    private CheckBox lotrCheckBox;

    @FXML
    private Label lotrLabel;

    @FXML
    private CheckBox runescapeCheckBox;

    @FXML
    private Label runescapeLabel;

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
        jatekok.put(gw2CheckBox,gw2Label);
        jatekok.put(wowCheckBox, wowLabel);
        jatekok.put(sodCheckBox, sodLabel);
        jatekok.put(ffCheckBox, ffLabel);
        jatekok.put(starwarsCheckBox,starwarsLabel);
        jatekok.put(aionCheckBox, aionLAbel);
        jatekok.put(dungeonCheckBox, dungeonLabel);
        jatekok.put(auraCheckBox, auraLabel);
        jatekok.put(lotrCheckBox, lotrLabel);
        jatekok.put(runescapeCheckBox, runescapeLabel);
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
