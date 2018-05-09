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
public class Main extends Application {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private Stage primaryStage;
    private BorderPane rootLayout;

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void init() throws Exception {
        logger.info("Uj programfuttatas tortent");
        JpaService.getJpaServiceInstance().setEntityManagerFactory(Persistence.createEntityManagerFactory("JatekAjanloProgram"));
        JpaService.getJpaServiceInstance().setEntityManager(JpaService.getJpaServiceInstance().getEntityManagerFactory().createEntityManager());
        JpaService.getJpaServiceInstance().setJatekokServiceJPA(new JatekokServiceJPA(JpaService.getJpaServiceInstance().getEntityManager()));
        JpaService.getJpaServiceInstance().setJatekvalasztasServiceJPA(new JatekvalasztasServiceJPA(JpaService.getJpaServiceInstance().getEntityManager()));
        logger.info("Sikeres adatbazis kapcsolat letrehozas");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        showValasztas();
    }

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

    @Override
    public void stop() throws Exception {
        JpaService.getJpaServiceInstance().getEntityManager().close();
        JpaService.getJpaServiceInstance().getEntityManagerFactory().close();
        logger.info("Sikeres adatbazis kapcsolat lebontas");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
