package ajanlo.optimalisKereso;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 * a keresőgráfban alkalmazott csomópontokat reprezentáló osztály.
 *
 */
public class Csucs {
    Allapot allapot;
    Csucs szulo;
    Operator eloallito;
    double utkoltseg;
    double jatekKoltseg;

    /**
     * Többparaméteres konstruktor, mely a paraméteres értékeken kívül
     * beállítja az útköltséget és a játékok árából álló játékköltséget.
     *
     * @param allapot a csomópont állapota
     * @param szulo az állapot szülő csúcsa
     * @param eloallito az állapotot előállító operátor
     */
    public Csucs(Allapot allapot, Csucs szulo, Operator eloallito) {
        this.allapot = allapot;
        this.szulo = szulo;
        this.eloallito = eloallito;
        this.utkoltseg = szulo == null ? 0 :
                szulo.utkoltseg + this.allapot.buntetes;
        this.jatekKoltseg = szulo == null ? 0 :
                szulo.jatekKoltseg + this.allapot.ar;
    }

    /**
     * egy csomópont kiiratásához szükséges felülírt toString metódus.
     *
     * @return visszatér a stringel
     */
    @Override
    public String toString() {
        return "Csucs{" +
                "allapot=" + allapot +
                ", szulo=" + szulo +
                ", eloallito=" + eloallito +
                ", utkoltseg=" + utkoltseg +
                ", jatekKoltseg=" + jatekKoltseg +
                '}';
    }
}
