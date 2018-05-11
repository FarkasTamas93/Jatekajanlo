package ajanlo.model;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */

/**
 * egy osztály mely azokhoz a játékosokhoz készült, akik ugyan azt az 5 játékot értékelték mint a felhasználó.
 *
 */
public class Vec5KlaszterErtek {
    private int jatek1Ertekeles;
    private int jatek2Ertekeles;
    private int jatek3Ertekeles;
    private int jatek4Ertekeles;
    private int jatek5Ertekeles;
    private String user;

    /**
     * paraméter nélküli konstruktor.
     *
     */
    public Vec5KlaszterErtek() {

    }

    /**
     * több paraméteres konstruktor.
     *
     * @param jatek1Ertekeles az 1. játék értékelése
     * @param jatek2Ertekeles a 2. játék értékelése
     * @param jatek3Ertekeles a 3. játék értékelése
     * @param jatek4Ertekeles a 4. játék értékelése
     * @param jatek5Ertekeles az 5. játék értékelése
     * @param user a játékos neve
     */
    public Vec5KlaszterErtek(int jatek1Ertekeles, int jatek2Ertekeles, int jatek3Ertekeles, int jatek4Ertekeles, int jatek5Ertekeles, String user) {
        this.jatek1Ertekeles = jatek1Ertekeles;
        this.jatek2Ertekeles = jatek2Ertekeles;
        this.jatek3Ertekeles = jatek3Ertekeles;
        this.jatek4Ertekeles = jatek4Ertekeles;
        this.jatek5Ertekeles = jatek5Ertekeles;
        this.user = user;
    }

    /**
     * lekéri a felhasználó nevét.
     *
     * @return a felhasználónevével tér vissza
     */
    public String getUser() {
        return user;
    }

    /**
     * beállítja a felhasználó nevét.
     *
     * @param user a felhasználó nevét várja
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * lkeéri az 1. játék értékelését.
     *
     * @return visszatér az 1. játék értékelésével
     */
    public int getJatek1Ertekeles() {
        return jatek1Ertekeles;
    }

    /**
     * beállítja az 1. játék értékelését.
     *
     * @param jatek1Ertekeles az 1. játék értékelését várja
     */
    public void setJatek1Ertekeles(int jatek1Ertekeles) {
        this.jatek1Ertekeles = jatek1Ertekeles;
    }

    /**
     * lkeéri a 3. játék értékelését.
     *
     * @return visszatér a 3. játék értékelésével
     */
    public int getJatek3Ertekeles() {
        return jatek3Ertekeles;
    }

    /**
     * beállítja a 3. játék értékelését.
     *
     * @param jatek3Ertekeles az 3. játék értékelését várja
     */
    public void setJatek3Ertekeles(int jatek3Ertekeles) {
        this.jatek3Ertekeles = jatek3Ertekeles;
    }

    /**
     * lkeéri a 2. játék értékelését.
     *
     * @return visszatér a 2. játék értékelésével
     */
    public int getJatek2Ertekeles() {
        return jatek2Ertekeles;
    }

    /**
     * beállítja a 2. játék értékelését.
     *
     * @param jatek2Ertekeles az 2. játék értékelését várja
     */
    public void setJatek2Ertekeles(int jatek2Ertekeles) {
        this.jatek2Ertekeles = jatek2Ertekeles;
    }

    /**
     * lkeéri a 4. játék értékelését.
     *
     * @return visszatér a 4. játék értékelésével
     */
    public int getJatek4Ertekeles() {
        return jatek4Ertekeles;
    }

    /**
     * beállítja a 4. játék értékelését.
     *
     * @param jatek4Ertekeles az 4. játék értékelését várja
     */
    public void setJatek4Ertekeles(int jatek4Ertekeles) {
        this.jatek4Ertekeles = jatek4Ertekeles;
    }

    /**
     * lkeéri az 5. játék értékelését.
     *
     * @return visszatér az 5. játék értékelésével
     */
    public int getJatek5Ertekeles() {
        return jatek5Ertekeles;
    }

    /**
     * beállítja az 5. játék értékelését.
     *
     * @param jatek5Ertekeles az 5. játék értékelését várja
     */
    public void setJatek5Ertekeles(int jatek5Ertekeles) {
        this.jatek5Ertekeles = jatek5Ertekeles;
    }
}
