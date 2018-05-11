package ajanlo.viewController;

import ajanlo.KivalasztottJatekokService;
import ajanlo.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */
public class ViewValasztasController {

    private static ViewValasztasController instance = new ViewValasztasController();

    /**
     *megdja az osztály példányt.
     *
     * @return visszatér a példánnyal
     */
    public static ViewValasztasController getInstance() {
        return instance;
    }

    /**
     * a kapott button id szerinti view-ot állítja be.
     *
     * @param mainApp mainapp
     * @param buttonId buttonid
     */
    public void viewValtas(Main mainApp,String buttonId){
        if(buttonId.equals("akcioButton")){
            mainApp.showAkcioJatekValasztas();
        }else if(buttonId.equals("kalandButton")){
            mainApp.showKalandJatekValasztas();
        }else if(buttonId.equals("horrorButton")){
            mainApp.showHorrorJatekValasztas();
        }else if(buttonId.equals("platformButton")){
            mainApp.showPlatformJatekValasztas();
        }else if(buttonId.equals("szimulatorButton")){
            mainApp.showSzimulatorJatekValasztas();
        }else if(buttonId.equals("ugyessegiButton")){
            mainApp.showUgyessegiJatekValasztas();
        }else if(buttonId.equals("szerepjatekButton")){
            mainApp.showSzerepJatekValasztas();
        }else {
            System.out.println("Hibas id");
        }
    }

    /**
     * validáció, kötelező 5 játék megadására,
     * hibaüzenetet ír kevés játék kiválasztása esetén.
     *
     * @param mainApp mainapp
     */
    public void viewValtasErtekeles(Main mainApp){
        if(KivalasztottJatekokService.getInstance().getJatekNevek().size() != 5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Keves adat");
            alert.setContentText("Kerlek 5 jatekot adj meg mielott tovabbmesz");
            alert.initOwner(mainApp.getPrimaryStage());
            alert.showAndWait();
        }else{
            mainApp.showKivalasztottJatekokErtekelese();
        }
    }
}
