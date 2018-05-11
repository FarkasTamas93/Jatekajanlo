package ajanlo.viewController;

import ajanlo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Farkas Tamas on 2018.05.04..
 */

/**
 * a kezdőképernyő.
 *
 */
public class ValasztasController {

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

    /**
     * megkapja a button id-ját, majd annak a view-ja töltődik be.
     *
     * @param event megkapja az eseményt
     */
    @FXML
    private void viewValasztas(ActionEvent event){
        String buttonId = ((Button)event.getSource()).getId();
        ViewValasztasController.getInstance().viewValtas(mainApp, buttonId);
    }

}
