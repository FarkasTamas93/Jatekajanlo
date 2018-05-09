package ajanlo.model;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */
public class Vec5KlaszterErtek {
    private int jatek1Ertekeles;
    private int jatek2Ertekeles;
    private int jatek3Ertekeles;
    private int jatek4Ertekeles;
    private int jatek5Ertekeles;
    private String user;

    public Vec5KlaszterErtek() {

    }

    public Vec5KlaszterErtek(int jatek1Ertekeles, int jatek2Ertekeles, int jatek3Ertekeles, int jatek4Ertekeles, int jatek5Ertekeles, String user) {
        this.jatek1Ertekeles = jatek1Ertekeles;
        this.jatek2Ertekeles = jatek2Ertekeles;
        this.jatek3Ertekeles = jatek3Ertekeles;
        this.jatek4Ertekeles = jatek4Ertekeles;
        this.jatek5Ertekeles = jatek5Ertekeles;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getJatek1Ertekeles() {
        return jatek1Ertekeles;
    }

    public void setJatek1Ertekeles(int jatek1Ertekeles) {
        this.jatek1Ertekeles = jatek1Ertekeles;
    }

    public int getJatek3Ertekeles() {
        return jatek3Ertekeles;
    }

    public void setJatek3Ertekeles(int jatek3Ertekeles) {
        this.jatek3Ertekeles = jatek3Ertekeles;
    }

    public int getJatek2Ertekeles() {
        return jatek2Ertekeles;
    }

    public void setJatek2Ertekeles(int jatek2Ertekeles) {
        this.jatek2Ertekeles = jatek2Ertekeles;
    }

    public int getJatek4Ertekeles() {
        return jatek4Ertekeles;
    }

    public void setJatek4Ertekeles(int jatek4Ertekeles) {
        this.jatek4Ertekeles = jatek4Ertekeles;
    }

    public int getJatek5Ertekeles() {
        return jatek5Ertekeles;
    }

    public void setJatek5Ertekeles(int jatek5Ertekeles) {
        this.jatek5Ertekeles = jatek5Ertekeles;
    }
}
