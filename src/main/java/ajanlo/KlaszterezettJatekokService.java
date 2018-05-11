package ajanlo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 *Singleton osztály, melybe feltöltjük a klaszterezés után a játékokat és azok átlagértékelését.
 *
 */
public class KlaszterezettJatekokService {

    private static KlaszterezettJatekokService klaszterezettJatekokService = new KlaszterezettJatekokService();

    private Map<String,Double> jatekokAtlagErtekelese = new HashMap<>();

    /**
     * paraméter nélküli konstruktor.
     *
     */
    private KlaszterezettJatekokService() {

    }

    /**
     * lekéri a klaszrezettJátékokService értékét.
     *
     * @return visszatér a klaszrezettJátékokService értékével
     */
    public static KlaszterezettJatekokService getKlaszterezettJatekokService() {
        return klaszterezettJatekokService;
    }

    /**
     * beállítja a klaszrezettJátékokService értékét.
     *
     * @param klaszterezettJatekokService várja a klaszrezettJátékokService értékét
     */
    public static void setKlaszterezettJatekokService(KlaszterezettJatekokService klaszterezettJatekokService) {
        KlaszterezettJatekokService.klaszterezettJatekokService = klaszterezettJatekokService;
    }

    /**
     * lekéri a játékok átlagértékelését.
     *
     * @return visszatér ajátékok átlagértékelésével
     */
    public Map<String, Double> getJatekokAtlagErtekelese() {
        return klaszterezettJatekokService.jatekokAtlagErtekelese;
    }

    /**
     * beállítja a játékok átlagérétkeését.
     *
     * @param jatekokAtlagErtekelese a játékok átlagértékelését várja
     */
    public void setJatekokAtlagErtekelese(Map<String, Double> jatekokAtlagErtekelese) {
        klaszterezettJatekokService.jatekokAtlagErtekelese = jatekokAtlagErtekelese;
    }
}
