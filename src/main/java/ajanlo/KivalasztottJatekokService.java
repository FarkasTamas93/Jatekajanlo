package ajanlo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */
public class KivalasztottJatekokService {

    private List<String> jatekNevek = new ArrayList<>();

    private static KivalasztottJatekokService instance = new KivalasztottJatekokService();

    public static KivalasztottJatekokService getInstance() {
        return instance;
    }

    public List<String> getJatekNevek() {
        return instance.jatekNevek;
    }

    public void addJatekNevek(String jatekNev) {
        if(instance.getJatekNevek().size()<5){
            instance.jatekNevek.add(jatekNev);
        }

    }

    public void removeJatekNevek(String jatekNev) {
        instance.jatekNevek.remove(jatekNev);
    }

}
