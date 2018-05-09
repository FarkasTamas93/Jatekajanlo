package ajanlo.model;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */
public class KlaszterezettJatekosok {
    private int ertekeles1;
    private int ertekeles2;
    private int ertekeles3;
    private int ertekeles4;
    private int ertekeles5;
    private String name;
    private int klaszter;

    public KlaszterezettJatekosok() {

    }

    public KlaszterezettJatekosok(int ertekeles1, int ertekeles2, int ertekeles3, int ertekeles4, int ertekeles5, String name, int klaszter) {
        this.ertekeles1 = ertekeles1;
        this.ertekeles2 = ertekeles2;
        this.ertekeles3 = ertekeles3;
        this.ertekeles4 = ertekeles4;
        this.ertekeles5 = ertekeles5;
        this.name = name;
        this.klaszter = klaszter;
    }

    public int getErtekeles1() {
        return ertekeles1;
    }

    public void setErtekeles1(int ertekeles1) {
        this.ertekeles1 = ertekeles1;
    }

    public int getErtekeles2() {
        return ertekeles2;
    }

    public void setErtekeles2(int ertekeles2) {
        this.ertekeles2 = ertekeles2;
    }

    public int getErtekeles3() {
        return ertekeles3;
    }

    public void setErtekeles3(int ertekeles3) {
        this.ertekeles3 = ertekeles3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKlaszter() {
        return klaszter;
    }

    public void setKlaszter(int klaszter) {
        this.klaszter = klaszter;
    }

    public int getErtekeles4() {
        return ertekeles4;
    }

    public void setErtekeles4(int ertekeles4) {
        this.ertekeles4 = ertekeles4;
    }

    public int getErtekeles5() {
        return ertekeles5;
    }

    public void setErtekeles5(int ertekeles5) {
        this.ertekeles5 = ertekeles5;
    }
}
