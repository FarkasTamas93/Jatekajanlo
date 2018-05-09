package ajanlo.optimalisKereso;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */
public class Operator {
    String jatekNev;
    int jatekAr;
    double atlag;

    Operator(String jatekNev,int jatekAr,double atlag){
        this.jatekNev=jatekNev;
        this.jatekAr=jatekAr;
        this.atlag=atlag;
    }

    public String getJatekNev() {
        return jatekNev;
    }

    public void setJatekNev(String jatekNev) {
        this.jatekNev = jatekNev;
    }

    public int getJatekAr() {
        return jatekAr;
    }

    public void setJatekAr(int jatekAr) {
        this.jatekAr = jatekAr;
    }

    public double getAtlag() {
        return atlag;
    }

    public void setAtlag(double atlag) {
        this.atlag = atlag;
    }

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

    public Allapot alkalmaz() {
        Allapot uj = new Allapot();
        uj.jateknev=this.jatekNev;
        uj.ar=this.jatekAr;
        uj.atlag=this.atlag;
        uj.buntetes=5-this.atlag;
        return uj;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "jatekNev='" + jatekNev + '\'' +
                ", jatekAr=" + jatekAr +
                ", atlag=" + atlag +
                '}';
    }
}
