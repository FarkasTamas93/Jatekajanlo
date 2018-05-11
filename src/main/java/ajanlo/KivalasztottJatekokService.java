package ajanlo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */

/**
 * Az osztály arra szolgál, hogy a felhasználói felületen, amikor check boxban kijelölődnek a játékok
 * vagy kikerül belőle a pipa akkor változtatja a lista összetételét.
 *
 */
public class KivalasztottJatekokService {

    private List<String> jatekNevek = new ArrayList<>();

    private static KivalasztottJatekokService instance = new KivalasztottJatekokService();

    /**
     *Lekéri a példányváltozó értékét.
     *
     * @return visszatér a példányváltozó értékével
     */
    public static KivalasztottJatekokService getInstance() {
        return instance;
    }

    /**
     *lekéri a játékok neveit.
     *
     * @return visszatér a játék névvel
     */
    public List<String> getJatekNevek() {
        return instance.jatekNevek;
    }

    /**
     * Hozzáadja a listához az aktuálisan kijelölt játék nevét,
     * amennyiben a lista mérete nem érte el az 5-öt.
     *
     * @param jatekNev a kijelölt játék neve
     */
    public void addJatekNevek(String jatekNev) {
        if(instance.getJatekNevek().size()<5){
            instance.jatekNevek.add(jatekNev);
        }

    }

    /**
     *ha egy játékról lekerül a kijelölés, akkor kitörli a listából a nevét.
     *
     * @param jatekNev A kitörlendő játék neve
     */
    public void removeJatekNevek(String jatekNev) {
        instance.jatekNevek.remove(jatekNev);
    }

}
