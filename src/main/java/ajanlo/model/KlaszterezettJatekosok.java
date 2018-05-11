package ajanlo.model;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */

/**
 * A klaszterbe került játékosok osztálya.
 *
 */
public class KlaszterezettJatekosok {
    private int ertekeles1;
    private int ertekeles2;
    private int ertekeles3;
    private int ertekeles4;
    private int ertekeles5;
    private String name;
    private int klaszter;

    /**
     * paraméter nélküli konstruktor.
     */
    public KlaszterezettJatekosok() {

    }

    /**
     * Több paraméteres konstruktor.
     *
     * @param ertekeles1 az 1. játék értékelése
     * @param ertekeles2 a 2. játék értékelése
     * @param ertekeles3 a 3. játék értékelése
     * @param ertekeles4 a 4. játék értékelése
     * @param ertekeles5 az 5. játék értékelése
     * @param name A klaszterbe került játékos neve
     * @param klaszter a klaszter száma amelybe a játékos került
     */
    public KlaszterezettJatekosok(int ertekeles1, int ertekeles2, int ertekeles3, int ertekeles4, int ertekeles5, String name, int klaszter) {
        this.ertekeles1 = ertekeles1;
        this.ertekeles2 = ertekeles2;
        this.ertekeles3 = ertekeles3;
        this.ertekeles4 = ertekeles4;
        this.ertekeles5 = ertekeles5;
        this.name = name;
        this.klaszter = klaszter;
    }

    /**
     * lekéri az 1. játék értékelését.
     *
     * @return visszatér az 1. játék értékelésével
     */
    public int getErtekeles1() {
        return ertekeles1;
    }

    /**
     * beállítja az 1. értékelés értékét.
     *
     * @param ertekeles1 az 1. értékelés értékét várja
     */
    public void setErtekeles1(int ertekeles1) {
        this.ertekeles1 = ertekeles1;
    }

    /**
     * lekéri a 2. játék értékelését.
     *
     * @return visszatér a 2. játék értékelésével
     */
    public int getErtekeles2() {
        return ertekeles2;
    }

    /**
     * beállítja a 2. értékelés értékét.
     *
     * @param ertekeles2 a 2. értékelés értékét várja
     */
    public void setErtekeles2(int ertekeles2) {
        this.ertekeles2 = ertekeles2;
    }
    /**
     * lekéri a 3. játék értékelését.
     *
     * @return visszatér a 3. játék értékelésével
     */
    public int getErtekeles3() {
        return ertekeles3;
    }

    /**
     * beállítja a 3. értékelés értékét.
     *
     * @param ertekeles3 a 3. értékelés értékét várja
     */
    public void setErtekeles3(int ertekeles3) {
        this.ertekeles3 = ertekeles3;
    }

    /**
     * lekéri a játékos nevét.
     *
     * @return visszatér a játékos nevével
     */
    public String getName() {
        return name;
    }

    /**
     * beállítja a játékos nevét.
     *
     * @param name a játékos nevét várja
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * lekéri a klaszter számát.
     *
     * @return visszatér a klaszter számával
     */
    public int getKlaszter() {
        return klaszter;
    }

    /**
     * beállítja a klaszter számát.
     *
     * @param klaszter a klaszter számát várja
     */
    public void setKlaszter(int klaszter) {
        this.klaszter = klaszter;
    }

    /**
     * lekéri a 4. játék értékelését.
     *
     * @return visszatér a 4. játék értékelésével
     */
    public int getErtekeles4() {
        return ertekeles4;
    }

    /**
     * beállítja a 4. értékelés értékét.
     *
     * @param ertekeles4 a 4. értékelés értékét várja
     */
    public void setErtekeles4(int ertekeles4) {
        this.ertekeles4 = ertekeles4;
    }
    /**
     * lekéri az 5. játék értékelését.
     *
     * @return visszatér az 5. játék értékelésével
     */
    public int getErtekeles5() {
        return ertekeles5;
    }


    /**
     * beállítja az 5. értékelés értékét.
     *
     * @param ertekeles5 az 5. értékelés értékét várja
     */
    public void setErtekeles5(int ertekeles5) {
        this.ertekeles5 = ertekeles5;
    }
}
