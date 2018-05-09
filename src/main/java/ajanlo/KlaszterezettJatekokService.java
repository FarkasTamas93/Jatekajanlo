package ajanlo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */
public class KlaszterezettJatekokService {

    private static KlaszterezettJatekokService klaszterezettJatekokService = new KlaszterezettJatekokService();

    private Map<String,Double> jatekokAtlagErtekelese = new HashMap<>();

    private KlaszterezettJatekokService() {

    }

    public static KlaszterezettJatekokService getKlaszterezettJatekokService() {
        return klaszterezettJatekokService;
    }

    public static void setKlaszterezettJatekokService(KlaszterezettJatekokService klaszterezettJatekokService) {
        KlaszterezettJatekokService.klaszterezettJatekokService = klaszterezettJatekokService;
    }

    public Map<String, Double> getJatekokAtlagErtekelese() {
        return klaszterezettJatekokService.jatekokAtlagErtekelese;
    }

    public void setJatekokAtlagErtekelese(Map<String, Double> jatekokAtlagErtekelese) {
        klaszterezettJatekokService.jatekokAtlagErtekelese = jatekokAtlagErtekelese;
    }
}
