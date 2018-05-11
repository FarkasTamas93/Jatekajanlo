package ajanlo.optimalisKereso;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 * az optimális keresőt megvalósító osztály.
 *
 */
public class Optimalis {

    /**
     * a megoldást alkotó operátorlistát állítja elő.
     *
     * @param terminalis megkapja a cél csúcsot.
     * @return visszatér a megoldáslistával.
     */
    public List<Operator> megoldas(Csucs terminalis) {
        LinkedList<Operator> megoldas = new LinkedList<Operator>();
        for (Csucs cs = terminalis; cs.szulo != null; cs = cs.szulo)
            megoldas.addFirst(cs.eloallito);
        return megoldas;
    }

    /**
     * az optimális kereső algoritmusa.
     *
     * @param p a probléma
     * @param elkolthetoPenz az elkölthető pénzmennyiség
     * @return visszatér a megoldással.
     */
    public List<Operator> keres(Problema p,int elkolthetoPenz) {
        LinkedList<Csucs> nyiltak = new LinkedList<Csucs>();
        LinkedList<Csucs> zartak = new LinkedList<Csucs>();
        // 1.
        nyiltak.add(new Csucs(p.kezdo(), null, null));
        while (true) {
            // 2.
            if (nyiltak.isEmpty()) {
                return null;
            }
            Collections.sort(nyiltak,(o1, o2) -> Double.compare(o1.utkoltseg,o2.utkoltseg));
//            for(Csucs cs : nyiltak){
//                System.out.println("Nyiltak:" + " " + "Allapot:" +cs.allapot + " " + "Szulo:" + " " + cs.szulo + " " + cs.utkoltseg);
//            }
            Csucs kivalasztott = nyiltak.removeFirst();
//            System.out.println("A kivalasztott:  " +kivalasztott);
            // 3.
//            if ( kivalasztott.allapot.cel() ) {
//                return megoldas(kivalasztott);
//            }
            zartak.add(kivalasztott);
            boolean belejott = false;
            for (Operator o : p.operatorok()) {
                if (o.alkalmazhato(kivalasztott,elkolthetoPenz)) {
 //                   System.out.println("Alkalmazhato operatorok: " +o);
                    Allapot uj = o.alkalmaz();
                    nyiltak.addLast(new Csucs(uj, kivalasztott, o));
                    belejott = true;
//                    System.out.println("Alkalmazott operatorok utani allapot:" + uj);
                }
            }
//            System.out.println(belejott);
            if (belejott == false) {
                return megoldas(kivalasztott);
            }
        }
    }

}
