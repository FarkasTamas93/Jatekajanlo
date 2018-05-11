package ajanlo.optimalisKereso;

import ajanlo.JpaService;
import ajanlo.model.Jatekok;

import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 * Az állapottér reprezentáció állapotait  reprezentáló osztály.
 *
 */
public class Allapot {

    String jateknev;
    int ar;
    double atlag;
    double buntetes;

    /**
     * Paraméter nélküli konstruktor, amey beállítja a kezdőűllapot értékeit.
     *
     */
    public Allapot() {
        this.jateknev = "root";
        this.ar = 0;
        this.atlag= 0.0;
        this.buntetes=0;
    }

//    public boolean cel(boolean vanAlkalmazhatoOperator) {
//        return vanAlkalmazhatoOperator;
//    }

    /**
     * az állapotok kiiratását elősegítő felülírt toString metódus.
     *
     * @return visszatér a stringel
     */
    @Override
    public String toString() {
        return "("+jateknev+","+ar+","+atlag + "," + buntetes +")";
    }

}
