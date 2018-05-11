package ajanlo.optimalisKereso;

import ajanlo.model.Jatekok;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 * Osztály azon játékok számára amelyek a játékosok maradék 10 játékából tevődik össze.
 *
 */
public class JatekokNeveEsAra {

    private List<Jatekok> jatekok = new ArrayList<>();

    private static JatekokNeveEsAra instance = new JatekokNeveEsAra();

    /**
     * lekéri az osztálypéldány értékét.
     *
     * @return visszatér az osztálypéldánnyal.
     */
    public static JatekokNeveEsAra getInstance() {
        return instance;
    }

    /**
     * Paraméter nélküli konstruktor.
     *
     */
    private JatekokNeveEsAra(){

    }

    /**
     * lekéri a játékok nevét.
     *
     * @return visszatér a játékok nevével.
     */
    public List<Jatekok> getJatekok() {
        return jatekok;
    }

    /**
     * beállítja a játékok nevét.
     *
     * @param jatekok játékok listát vár.
     */
    public void setJatekok(List<Jatekok> jatekok) {
        this.jatekok = jatekok;
    }
}
