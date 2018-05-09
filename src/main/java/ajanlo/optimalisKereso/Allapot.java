package ajanlo.optimalisKereso;

import ajanlo.JpaService;
import ajanlo.model.Jatekok;

import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */
public class Allapot {

    String jateknev;
    int ar;
    double atlag;
    double buntetes;

    public Allapot() {
        this.jateknev = "root";
        this.ar = 0;
        this.atlag= 0.0;
        this.buntetes=0;
    }

//    public boolean cel(boolean vanAlkalmazhatoOperator) {
//        return vanAlkalmazhatoOperator;
//    }

    @Override
    public String toString() {
        return "("+jateknev+","+ar+","+atlag + "," + buntetes +")";
    }

}
