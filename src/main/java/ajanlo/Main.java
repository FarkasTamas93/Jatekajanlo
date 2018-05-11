package ajanlo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ajanlo.viewController.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Persistence;
import java.io.IOException;

/**
 * Created by Farkas Tamas on 2017.04.29..
 */

/**
 * A main osztály, mely kiterjeszti az Application osztályt, ettől lesz az alkalmazás JavaFX alkalmazás
 * felülírja az init, start és stop metódusokat.
 *
 */
public class Main extends Application {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * LEkéri a RootLayout-ot.
     *
     * @return visszatér a RootLayout-al
     */
    public BorderPane getRootLayout() {
        return rootLayout;
    }

    /**
     * LEkéri a PrimaryStage-et.
     *
     * @return visszatér a PrimaryStage-el
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * az alkalmazás inicializáló metódusa. Az adtabázis kalpcsolat felépítését végzi.
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        logger.info("Uj programfuttatas tortent");
        JpaService.getJpaServiceInstance().setEntityManagerFactory(Persistence.createEntityManagerFactory("JatekAjanloProgram"));
        JpaService.getJpaServiceInstance().setEntityManager(JpaService.getJpaServiceInstance().getEntityManagerFactory().createEntityManager());
        JpaService.getJpaServiceInstance().setJatekokServiceJPA(new JatekokServiceJPA(JpaService.getJpaServiceInstance().getEntityManager()));
        JpaService.getJpaServiceInstance().setJatekvalasztasServiceJPA(new JatekvalasztasServiceJPA(JpaService.getJpaServiceInstance().getEntityManager()));
        logger.info("Sikeres adatbazis kapcsolat letrehozas");
    }

    /**
     * A JavaFx alkalmazás belépési pontja. az init metódus után fut le.
     * beállítja a primaryStage értékét, meghívja a RootLayout inicializációját,
     * majd a választás scen-t tölti be.
     *
     * @param primaryStage a primaryStage értékét várja
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        showValasztas();
    }

    /**
     * A rootLayout inicializálása.
     *
     */
    public void initRootLayout() {
        try {
            // Load root layout from view file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.show();
            RootLayoutViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Az akciójátékok Scene beállítása.
     *
     */
    public void showAkcioJatekValasztas() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/AkcioJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            AkcioJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az horrorjátékok Scene beállítása.
     *
     */
    public void showHorrorJatekValasztas() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/HorrorJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            HorrorJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az kalandjátékok Scene beállítása.
     *
     */
    public void showKalandJatekValasztas() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/KalandJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            KalandJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az platformjátékok Scene beállítása.
     *
     */
    public void showPlatformJatekValasztas()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/PlatformJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            PlatformJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az szerepjátékok Scene beállítása.
     *
     */
    public void showSzerepJatekValasztas()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/SzerepJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            SzerepJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az ügyességijátékok Scene beállítása.
     *
     */
    public void showUgyessegiJatekValasztas()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/UgyessegiJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            UgyessegiJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az szimulátorjátékok Scene beállítása.
     *
     */
    public void showSzimulatorJatekValasztas()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/SzimulatorJatekValasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            SzimulatorJatekViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A kezdőképernyő Scene beállítása.
     *
     */
    public void showValasztas()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/Valasztas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            ValasztasController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az értékelés Scene beállítása.
     *
     */
    public void showKivalasztottJatekokErtekelese()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/KivalasztottJatekokErtekelese.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            KivalasztottJatekokErtekeleseViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Az játék ajánlás Scene beállítása.
     *
     */
    public void showAjanlas()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/JatekAjanlas.fxml"));
            AnchorPane centerView = (AnchorPane) loader.load();
            this.primaryStage.setMaximized(true);
            rootLayout.setCenter(centerView);
            JatekAjanlasViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ez a metódus hívódik meg amikor a programnak le kell állnia.
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        JpaService.getJpaServiceInstance().getEntityManager().close();
        JpaService.getJpaServiceInstance().getEntityManagerFactory().close();
        logger.info("Sikeres adatbazis kapcsolat lebontas");
    }

    /**
     * A program belépési pontja.
     *
     * @param args argumentum lista
     */
    public static void main(String[] args) {
        launch(args);
    }
}
