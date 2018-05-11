package ajanlo.optimalisKereso;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 * Az állapottér reprezentációban az operátorok halmazát reprezentáló osztály.
 *
 */
public class Operator {
    String jatekNev;
    int jatekAr;
    double atlag;

    /**
     * több paraméteres konstruktor.
     *
     * @param jatekNev A játék neve
     * @param jatekAr a játék ára
     * @param atlag a játék átlag értékelése
     */
    Operator(String jatekNev,int jatekAr,double atlag){
        this.jatekNev=jatekNev;
        this.jatekAr=jatekAr;
        this.atlag=atlag;
    }

    /**
     * lekéri a játékok nevét.
     *
     * @return visszatér ajátékok nevével
     */
    public String getJatekNev() {
        return jatekNev;
    }

    /**
     * beállítja a játék nevét.
     *
     * @param jatekNev a játék nevét várja
     */
    public void setJatekNev(String jatekNev) {
        this.jatekNev = jatekNev;
    }

    /**
     * lekéri a játék árát.
     *
     * @return visszatér a játék árával.
     */
    public int getJatekAr() {
        return jatekAr;
    }

    /**
     * beállítja a játék árát.
     *
     * @param jatekAr a játék árát várja
     */
    public void setJatekAr(int jatekAr) {
        this.jatekAr = jatekAr;
    }

    /**
     * lekéri a játék átlagértékelését.
     *
     * @return visszatér a játék átlagérétkével
     */
    public double getAtlag() {
        return atlag;
    }

    /**
     * beállítja a játék átlagértékelését.
     *
     * @param atlag a játék átlagértkelését várja
     */
    public void setAtlag(double atlag) {
        this.atlag = atlag;
    }

    /**
     * eldől, hogy melyik állapotokra alkalmazható az adott operátor,
     * ha alkalmazható true, ha nem akkor false.
     *
     * @param aktualis várja az aktuális csomópontot
     * @param elkolthetoPenz várja az elkölthető pénz mennyiséget
     * @return visszatér egy logikai értékkel.
     */
    public boolean alkalmazhato(Csucs aktualis,int elkolthetoPenz) {
        LinkedList<String> utonLevoJatekNevek = new LinkedList<String>();
        for (Csucs cs=aktualis; cs.szulo != null; cs=cs.szulo) {
            utonLevoJatekNevek.addFirst(cs.allapot.jateknev);
        }

        for(String jatekNevek: utonLevoJatekNevek){
            if (this.jatekNev.equals(jatekNevek)){
                return false;
            }
        }

        if(aktualis.jatekKoltseg + this.jatekAr <= elkolthetoPenz){
            return true;
        }else{
            return false;
        }
    }

    /**
     * az operátor alkalmazás eredményéül, beállítódnak az állapot adatai.
     *
     * @return visszatér az új állapottal
     */
    public Allapot alkalmaz() {
        Allapot uj = new Allapot();
        uj.jateknev=this.jatekNev;
        uj.ar=this.jatekAr;
        uj.atlag=this.atlag;
        uj.buntetes=5-this.atlag;
        return uj;
    }

    /**
     * az operátor kiírását elősegítő felülírt toString metódus.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Operator{" +
                "jatekNev='" + jatekNev + '\'' +
                ", jatekAr=" + jatekAr +
                ", atlag=" + atlag +
                '}';
    }
}
