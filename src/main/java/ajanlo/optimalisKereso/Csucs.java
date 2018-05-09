package ajanlo.optimalisKereso;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */
public class Csucs {
    Allapot allapot;
    Csucs szulo;
    Operator eloallito;
    double utkoltseg;
    double jatekKoltseg;

    public Csucs(Allapot allapot, Csucs szulo, Operator eloallito) {
        this.allapot = allapot;
        this.szulo = szulo;
        this.eloallito = eloallito;
        this.utkoltseg = szulo == null ? 0 :
                szulo.utkoltseg + this.allapot.buntetes;
        this.jatekKoltseg = szulo == null ? 0 :
                szulo.jatekKoltseg + this.allapot.ar;
    }

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
