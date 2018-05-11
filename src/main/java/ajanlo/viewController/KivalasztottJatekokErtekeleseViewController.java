package ajanlo.viewController;

import ajanlo.*;
import ajanlo.Timer;
import ajanlo.model.Jatekvalasztas;
import ajanlo.model.KlaszterezettJatekosok;
import ajanlo.model.Vec5KlaszterErtek;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.*;

/**
 * Created by Farkas Tamas on 2017.12.31..
 */

public class KivalasztottJatekokErtekeleseViewController {

    List<String> felvettJatekok;
    ArrayList<Label> labelList = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(KivalasztottJatekokErtekeleseViewController.class);

    private Main mainApp;
    /**
     * beállítja a mainAppot.
     *
     * @param mainApp megkapja a mainApp-ot
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private Label kivalasztott1;

    @FXML
    private Label kivalasztott2;

    @FXML
    private Label kivalasztott3;

    @FXML
    private Label kivalasztott4;

    @FXML
    private Label kivalasztott5;

    @FXML
    private Slider kivalasztottSlide1;

    @FXML
    private Slider kivalasztottSlide2;

    @FXML
    private Slider kivalasztottSlide3;

    @FXML
    private Slider kivalasztottSlide4;

    @FXML
    private Slider kivalasztottSlide5;

    @FXML
    private void initialize() {
        felvettJatekok = KivalasztottJatekokService.getInstance().getJatekNevek();
        KiiratasController.getInstance().labelArrayInit(labelList, kivalasztott1, kivalasztott2, kivalasztott3, kivalasztott4, kivalasztott5);
        KiiratasController.getInstance().kivalasztottJatekokKiiratasa(felvettJatekok.size(), labelList);
    }

    @FXML
    private void felhasznaloiertekeles() {

        TimerNano timer = new TimerNano();
        timer.start();

        Map<String, Integer> kivalasztott5Jatek = kivalasztott5JatekNeveEsErtekelese();

        Vec5KlaszterErtek sajat5Ertekeles = new Vec5KlaszterErtek(kivalasztott5Jatek.get(felvettJatekok.get(0)), kivalasztott5Jatek.get(felvettJatekok.get(1)), kivalasztott5Jatek.get(felvettJatekok.get(2)), kivalasztott5Jatek.get(felvettJatekok.get(3)), kivalasztott5Jatek.get(felvettJatekok.get(4)), "newUser");

        List<String> ertekelt5JatekNeve = new ArrayList<>(kivalasztott5Jatek.keySet());

        List<Jatekvalasztas> osszesEmberAkiUgyanAztAJatekotErtekelte = ugyanazonJatekErtekelesek(ertekelt5JatekNeve);

        List<Vec5KlaszterErtek> osszesEmberUgyanazon5JatekErtekeleseiAmitErtekeltunk = klaszterElemekFeltoltese(osszesEmberAkiUgyanAztAJatekotErtekelte, ertekelt5JatekNeve, sajat5Ertekeles);

        KKozepKlaszter klaszterezes = new KKozepKlaszter();

        klaszterezes.setOsszes_adat(osszesEmberUgyanazon5JatekErtekeleseiAmitErtekeltunk.size());

        klaszterezes.initialize(osszesEmberUgyanazon5JatekErtekeleseiAmitErtekeltunk);

        klaszterezes.kKozepKlaszterezes(osszesEmberUgyanazon5JatekErtekeleseiAmitErtekeltunk);

        List<KlaszterezettJatekosok> klaszterezettJatekosokListaja = klaszterezes.klaszterezettJatekosok();

        jatekAjanlasa(klaszterezettJatekosokListaja, osszesEmberAkiUgyanAztAJatekotErtekelte);

        timer.end();

        System.out.println("Timer is :" + timer.getTotalTime());

        logger.info("Sikeres ertekeles");

        mainApp.showAjanlas();
    }

    private Map<String, Double> jatekAjanlasa(List<KlaszterezettJatekosok> klaszterezettJatekosokListaja, List<Jatekvalasztas> osszesEmberAkiUgyanAztAJatekotErtekelte) {
        List<String> jatekokNeveKlaszterezettEmberektol = new ArrayList<>();

        List<Integer> jatekokErtekeleseKlaszterezettEmberektol = new ArrayList<>();

        osszesJatekNeveEsErtekeleseKiveve5Jatekot(klaszterezettJatekosokListaja, osszesEmberAkiUgyanAztAJatekotErtekelte, jatekokNeveKlaszterezettEmberektol, jatekokErtekeleseKlaszterezettEmberektol);

        List<String> nemIsmetlodoJatekok = klaszterezettJatekosokJatekaiIsmetlodesNelkul(jatekokNeveKlaszterezettEmberektol);

        Map<String, Double> ertekelesekOsszesitve = jatekokNeveEsAtlagertekelese(nemIsmetlodoJatekok,jatekokNeveKlaszterezettEmberektol,jatekokErtekeleseKlaszterezettEmberektol);

        KlaszterezettJatekokService.getKlaszterezettJatekokService().setJatekokAtlagErtekelese(ertekelesekOsszesitve);
/*
        for (Map.Entry k : ertekelesekOsszesitve.entrySet()) {
            System.out.println("Ujak :" + k.getKey() + " " + k.getValue());
        }
*/
        return ertekelesekOsszesitve;
    }

    private Map<String, Double> jatekokNeveEsAtlagertekelese(List<String> nemIsmetlodoJatekok,List<String> jatekokNeveKlaszterezettEmberektol,List<Integer> jatekokErtekeleseKlaszterezettEmberektol){
        Map<String, Double> ertekelesekOsszesitve = new HashMap<>();

        for (int i = 0; i < nemIsmetlodoJatekok.size(); i++) {
            int occurrences = 0;
            double szamitottErtek = 0.0;
            int jatekOsszesErtekeles = ertekelesekOsszesites(jatekokNeveKlaszterezettEmberektol, jatekokErtekeleseKlaszterezettEmberektol, nemIsmetlodoJatekok.get(i));
//            System.out.println("JatekosszErtekeles: " + jatekOsszesErtekeles);
            occurrences = Collections.frequency(jatekokNeveKlaszterezettEmberektol, nemIsmetlodoJatekok.get(i));
//            System.out.println("Elofordulas " + occurrences);
            if (occurrences == 1) {
                szamitottErtek = ((double) jatekOsszesErtekeles / occurrences) * ((double) 42 / 50);
            } else if (occurrences == 2) {
                szamitottErtek = ((double) jatekOsszesErtekeles / occurrences) * ((double) 44 / 50);
            } else if (occurrences == 3) {
                szamitottErtek = ((double) jatekOsszesErtekeles / occurrences) * ((double) 46 / 50);
            } else if (occurrences == 4) {
                szamitottErtek = ((double) jatekOsszesErtekeles / occurrences) * ((double) 48 / 50);
            } else {
                szamitottErtek = ((double) jatekOsszesErtekeles / occurrences);
            }
            ertekelesekOsszesitve.put(nemIsmetlodoJatekok.get(i), szamitottErtek);
        }

        return ertekelesekOsszesitve;
    }

    private List<String> klaszterezettJatekosokJatekaiIsmetlodesNelkul(List<String> jatekokNeveKlaszterezettEmberektol){
        Set<String> szukitettLista = new HashSet<>();
        szukitettLista.addAll(jatekokNeveKlaszterezettEmberektol);
        List<String> nemIsmetlodoJatekok = new ArrayList<>();
        nemIsmetlodoJatekok.addAll(szukitettLista);
        return  nemIsmetlodoJatekok;
    }

    private void osszesJatekNeveEsErtekeleseKiveve5Jatekot(List<KlaszterezettJatekosok> klaszterezettJatekosokListaja, List<Jatekvalasztas> osszesEmberAkiUgyanAztAJatekotErtekelte,List<String> jatekokNeveKlaszterezettEmberektol,List<Integer> jatekokErtekeleseKlaszterezettEmberektol){
        for (int i = 0; i < klaszterezettJatekosokListaja.size(); i++) {
            for (int j = 0; j < osszesEmberAkiUgyanAztAJatekotErtekelte.size(); j++) {
                if (klaszterezettJatekosokListaja.get(i).getName().equals(osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).getUserName())) {
                    for (int k = 1; k < 16; k++) {
                        if (osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekById(k).equals(felvettJatekok.get(0))) {
                            continue;
                        }
                        if (osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekById(k).equals(felvettJatekok.get(1))) {
                            continue;
                        }
                        if (osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekById(k).equals(felvettJatekok.get(2))) {
                            continue;
                        }
                        if (osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekById(k).equals(felvettJatekok.get(3))) {
                            continue;
                        }
                        if (osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekById(k).equals(felvettJatekok.get(4))) {
                            continue;
                        }
                        jatekokNeveKlaszterezettEmberektol.add(osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekById(k));
                        jatekokErtekeleseKlaszterezettEmberektol.add(osszesEmberAkiUgyanAztAJatekotErtekelte.get(j).jatekErtekelesById(k));
                    }
                }
            }
        }
    }

    private int ertekelesekOsszesites(List<String> osszesJatekNeve, List<Integer> osszesJatekErtekelese, String jatekNeve) {
        int adottJatekErtekelese = 0;
        for (int i = 0; i < osszesJatekErtekelese.size(); i++) {
            if (osszesJatekNeve.get(i).equals(jatekNeve)) {
                adottJatekErtekelese += osszesJatekErtekelese.get(i);
            }
        }
        return adottJatekErtekelese;
    }

    private List<Vec5KlaszterErtek> klaszterElemekFeltoltese(List<Jatekvalasztas> osszesEmberAkiUgyanAztAJatekotErtekelte, List<String> sajat5JatekNeve, Vec5KlaszterErtek sajatErtekelesunk) {

        List<Vec5KlaszterErtek> klaszterElemek = new ArrayList<>();

        for (int i = 0; i < osszesEmberAkiUgyanAztAJatekotErtekelte.size(); i++) {

            Vec5KlaszterErtek temp = new Vec5KlaszterErtek();

            temp.setUser(osszesEmberAkiUgyanAztAJatekotErtekelte.get(i).getUserName());

            List<String> a15JatekNeve = osszesEmberAkiUgyanAztAJatekotErtekelte.get(i).getOsszesJatekNev();

            List<Integer> a15JatekErtekelese = osszesEmberAkiUgyanAztAJatekotErtekelte.get(i).getOsszesJatekErtekeles();

            for (int j = 0; j < a15JatekNeve.size(); j++) {
                if (a15JatekNeve.get(j).equals(sajat5JatekNeve.get(0))) {
                    temp.setJatek1Ertekeles(a15JatekErtekelese.get(j));
                    break;
                }
            }

            for (int j = 0; j < a15JatekNeve.size(); j++) {
                if (a15JatekNeve.get(j).equals(sajat5JatekNeve.get(1))) {
                    temp.setJatek2Ertekeles(a15JatekErtekelese.get(j));
                    break;
                }
            }

            for (int j = 0; j < a15JatekNeve.size(); j++) {
                if (a15JatekNeve.get(j).equals(sajat5JatekNeve.get(2))) {
                    temp.setJatek3Ertekeles(a15JatekErtekelese.get(j));
                    break;
                }
            }

            for (int j = 0; j < a15JatekNeve.size(); j++) {
                if (a15JatekNeve.get(j).equals(sajat5JatekNeve.get(3))) {
                    temp.setJatek4Ertekeles(a15JatekErtekelese.get(j));
                    break;
                }
            }

            for (int j = 0; j < a15JatekNeve.size(); j++) {
                if (a15JatekNeve.get(j).equals(sajat5JatekNeve.get(4))) {
                    temp.setJatek5Ertekeles(a15JatekErtekelese.get(j));
                    break;
                }
            }

            klaszterElemek.add(temp);
        }

        klaszterElemek.add(sajatErtekelesunk);
        return klaszterElemek;
    }

    private List<Jatekvalasztas> ugyanazonJatekErtekelesek(List<String> lista) {
        List<Jatekvalasztas> osszes = new ArrayList<>();
        osszes = JpaService.getJpaServiceInstance().getJatekvalasztasServiceJPA().getHasonloJatekok(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4));
        return osszes;
    }

    private Map<String, Integer> kivalasztott5JatekNeveEsErtekelese() {
        Map<String, Integer> map = new HashMap<>();
        map.put(kivalasztott1.getText(), (int) kivalasztottSlide1.getValue());
        map.put(kivalasztott2.getText(), (int) kivalasztottSlide2.getValue());
        map.put(kivalasztott3.getText(), (int) kivalasztottSlide3.getValue());
        map.put(kivalasztott4.getText(), (int) kivalasztottSlide4.getValue());
        map.put(kivalasztott5.getText(), (int) kivalasztottSlide5.getValue());
        return map;
    }

    @FXML
    private void jatekokValasztasButton() {
        mainApp.showAkcioJatekValasztas();
    }

}
