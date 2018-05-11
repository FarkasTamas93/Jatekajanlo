package ajanlo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */

/**
 * entity osztály a különböző felhasználók játék értékeléseihez.
 *
 */
@Entity
public class Jatekvalasztas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Paraméter nélküli konstruktor.
     *
     */
    public Jatekvalasztas() {
    }

    /**
     * Több paraméteres konstruktor.
     *
     * @param userName A játékos neve.
     * @param jatek1 az 1. játéka
     * @param jatek1Ertekeles az 1. játék értékelése
     * @param jatek2 a 2. játéka
     * @param jatek2Ertekeles a 2. játék értékelése
     * @param jatek3 a 3. játéka
     * @param jatek3Ertekeles a 3. játék értékelése
     * @param jatek4 a 4. játéka
     * @param jatek4Ertekeles a 4. játék értékelése
     * @param jatek5 az 5. játéka
     * @param jatek5Ertekeles az 5. játék értékelése
     * @param jatek6 a 6. játéka
     * @param jatek6Ertekeles a 6. játék értékelése
     * @param jatek7 a 7. játéka
     * @param jatek7Ertekeles a 7. játék értékelése
     * @param jatek8 a 8. játéka
     * @param jatek8Ertekeles a 8. játék értékelése
     * @param jatek9 a 9. játéka
     * @param jatek9Ertekeles a 9. játék értékelése
     * @param jatek10 a 10. játéka
     * @param jatek10Ertekeles a 10. játék értékelése
     * @param jatek11 a 11. játéka
     * @param jatek11Ertekeles a 11. játék értékelése
     * @param jatek12 a 12. játéka
     * @param jatek12Ertekeles a 12. játék értékelése
     * @param jatek13 a 13. játéka
     * @param jatek13Ertekeles a 13. játék értékelése
     * @param jatek14 a 14. játéka
     * @param jatek14Ertekeles a 14. játék értékelése
     * @param jatek15 a 15. játéka
     * @param jatek15Ertekeles a 15. játék értékelése
     */
    public Jatekvalasztas(String userName, String jatek1, int jatek1Ertekeles, String jatek2, int jatek2Ertekeles, String jatek3, int jatek3Ertekeles, String jatek4, int jatek4Ertekeles, String jatek5, int jatek5Ertekeles, String jatek6, int jatek6Ertekeles, String jatek7, int jatek7Ertekeles, String jatek8, int jatek8Ertekeles, String jatek9, int jatek9Ertekeles, String jatek10, int jatek10Ertekeles, String jatek11, int jatek11Ertekeles, String jatek12, int jatek12Ertekeles, String jatek13, int jatek13Ertekeles, String jatek14, int jatek14Ertekeles, String jatek15, int jatek15Ertekeles) {
        this.userName = userName;
        this.jatek1 = jatek1;
        this.jatek1Ertekeles = jatek1Ertekeles;
        this.jatek2 = jatek2;
        this.jatek2Ertekeles = jatek2Ertekeles;
        this.jatek3 = jatek3;
        this.jatek3Ertekeles = jatek3Ertekeles;
        this.jatek4 = jatek4;
        this.jatek4Ertekeles = jatek4Ertekeles;
        this.jatek5 = jatek5;
        this.jatek5Ertekeles = jatek5Ertekeles;
        this.jatek6 = jatek6;
        this.jatek6Ertekeles = jatek6Ertekeles;
        this.jatek7 = jatek7;
        this.jatek7Ertekeles = jatek7Ertekeles;
        this.jatek8 = jatek8;
        this.jatek8Ertekeles = jatek8Ertekeles;
        this.jatek9 = jatek9;
        this.jatek9Ertekeles = jatek9Ertekeles;
        this.jatek10 = jatek10;
        this.jatek10Ertekeles = jatek10Ertekeles;
        this.jatek11 = jatek11;
        this.jatek11Ertekeles = jatek11Ertekeles;
        this.jatek12 = jatek12;
        this.jatek12Ertekeles = jatek12Ertekeles;
        this.jatek13 = jatek13;
        this.jatek13Ertekeles = jatek13Ertekeles;
        this.jatek14 = jatek14;
        this.jatek14Ertekeles = jatek14Ertekeles;
        this.jatek15 = jatek15;
        this.jatek15Ertekeles = jatek15Ertekeles;
    }

    /**
     * Lekéri az 5. játékértékelés értékét.
     *
     * @return visszatér az 5. játék értékelésével
     */
    public int getJatek5Ertekeles() {
        return jatek5Ertekeles;
    }

    /**
     * Beállítja az 5. játékértékelés étékét.
     *
     * @param jatek5Ertekeles az 5. játék értékelése
     */
    public void setJatek5Ertekeles(int jatek5Ertekeles) {
        this.jatek5Ertekeles = jatek5Ertekeles;
    }

    /**
     * lekéri az azonosítót.
     *
     * @return visszatér az azonosítóval
     */
    public long getId() {
        return id;
    }

    /**
     * beállítja az azonosító étékét.
     *
     * @param id az azonosító értékét várja
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Lekéri a játékos felhasznlónevét.
     *
     * @return visszatér a játékos felhasználónevével
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Beállítja a játékos felhasználónevét.
     *
     * @param userName a játékos felhasználónevét várja
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * lekéri az 1. játék nevét.
     *
     * @return visszatér az 1. játék nevével
     */
    public String getJatek1() {
        return jatek1;
    }

    /**
     * beállítja az 1. játék nevét.
     *
     * @param jatek1 az 1. játék nevét várja
     */
    public void setJatek1(String jatek1) {
        this.jatek1 = jatek1;
    }

    /**
     * Lekéri az 1. játékértékelés értékét.
     *
     * @return visszatér az 1. játék értékelésével
     */
    public int getJatek1Ertekeles() {
        return jatek1Ertekeles;
    }

    /**
     * Beállítja az 1. játékértékelés étékét.
     *
     * @param jatek1Ertekeles az 1. játék értékelése
     */
    public void setJatek1Ertekeles(int jatek1Ertekeles) {
        this.jatek1Ertekeles = jatek1Ertekeles;
    }

    /**
     * lekéri a 2. játék nevét.
     *
     * @return visszatér a 2. játék nevével
     */
    public String getJatek2() {
        return jatek2;
    }

    /**
     * beállítja a 2. játék nevét.
     *
     * @param jatek2 a 2. játék nevét várja
     */
    public void setJatek2(String jatek2) {
        this.jatek2 = jatek2;
    }

    /**
     * Lekéri a 2. játékértékelés értékét.
     *
     * @return visszatér a 2. játék értékelésével
     */
    public int getJatek2Ertekeles() {
        return jatek2Ertekeles;
    }

    /**
     * Beállítja a 2. játékértékelés étékét.
     *
     * @param jatek2Ertekeles a 2. játék értékelése
     */
    public void setJatek2Ertekeles(int jatek2Ertekeles) {
        this.jatek2Ertekeles = jatek2Ertekeles;
    }

    /**
     * lekéri a 3. játék nevét.
     *
     * @return visszatér a 3. játék nevével
     */
    public String getJatek3() {
        return jatek3;
    }

    /**
     * beállítja a 3. játék nevét.
     *
     * @param jatek3 a 3. játék nevét várja
     */
    public void setJatek3(String jatek3) {
        this.jatek3 = jatek3;
    }

    /**
     * Lekéri a 3. játékértékelés értékét.
     *
     * @return visszatér a 3. játék értékelésével
     */
    public int getJatek3Ertekeles() {
        return jatek3Ertekeles;
    }

    /**
     * Beállítja a 3. játékértékelés étékét.
     *
     * @param jatek3Ertekeles a 3. játék értékelése
     */
    public void setJatek3Ertekeles(int jatek3Ertekeles) {
        this.jatek3Ertekeles = jatek3Ertekeles;
    }

    /**
     * lekéri a 4. játék nevét.
     *
     * @return visszatér a 4. játék nevével
     */
    public String getJatek4() {
        return jatek4;
    }

    /**
     * beállítja a 4. játék nevét.
     *
     * @param jatek4 a 4. játék nevét várja
     */
    public void setJatek4(String jatek4) {
        this.jatek4 = jatek4;
    }

    /**
     * Lekéri a 4. játékértékelés értékét.
     *
     * @return visszatér a 4. játék értékelésével
     */
    public int getJatek4Ertekeles() {
        return jatek4Ertekeles;
    }

    /**
     * Beállítja a 4. játékértékelés étékét.
     *
     * @param jatek4Ertekeles a 4. játék értékelése
     */
    public void setJatek4Ertekeles(int jatek4Ertekeles) {
        this.jatek4Ertekeles = jatek4Ertekeles;
    }

    /**
     * lekéri az 5. játék nevét.
     *
     * @return visszatér az 5. játék nevével
     */
    public String getJatek5() {
        return jatek5;
    }

    /**
     * beállítja az 5. játék nevét.
     *
     * @param jatek5 az 5. játék nevét várja
     */
    public void setJatek5(String jatek5) {
        this.jatek5 = jatek5;
    }

    /**
     * lekéri a 6. játék nevét
     *
     * @return visszatér a 6. játék nevével
     */
    public String getJatek6() {
        return jatek6;
    }

    /**
     * beállítja a 3. játék nevét.
     *
     * @param jatek6 a 6. játék nevét várja
     */
    public void setJatek6(String jatek6) {
        this.jatek6 = jatek6;
    }

    /**
     * Lekéri a 6. játékértékelés értékét.
     *
     * @return visszatér a 6. játék értékelésével
     */
    public int getJatek6Ertekeles() {
        return jatek6Ertekeles;
    }

    /**
     * Beállítja a 6. játékértékelés étékét.
     *
     * @param jatek6Ertekeles a 6. játék értékelése
     */
    public void setJatek6Ertekeles(int jatek6Ertekeles) {
        this.jatek6Ertekeles = jatek6Ertekeles;
    }

    /**
     * lekéri a 7. játék nevét.
     *
     * @return visszatér a 7. játék nevével
     */
    public String getJatek7() {
        return jatek7;
    }

    /**
     * beállítja a 7. játék nevét.
     *
     * @param jatek7 a 7. játék nevét várja
     */
    public void setJatek7(String jatek7) {
        this.jatek7 = jatek7;
    }

    /**
     * Lekéri a 7. játékértékelés értékét.
     *
     * @return visszatér a 7. játék értékelésével
     */
    public int getJatek7Ertekeles() {
        return jatek7Ertekeles;
    }

    /**
     * Beállítja a 7. játékértékelés étékét.
     *
     * @param jatek7Ertekeles a 7. játék értékelése
     */
    public void setJatek7Ertekeles(int jatek7Ertekeles) {
        this.jatek7Ertekeles = jatek7Ertekeles;
    }
     /**
     * lekéri a 8. játék nevét.
     *
     * @return visszatér a 8. játék nevével
     */
    public String getJatek8() {
        return jatek8;
    }

    /**
     * beállítja a 8. játék nevét.
     *
     * @param jatek8 a 8. játék nevét várja
     */
    public void setJatek8(String jatek8) {
        this.jatek8 = jatek8;
    }

    /**
     * Lekéri a 8. játékértékelés értékét.
     *
     * @return visszatér a 8. játék értékelésével
     */
    public int getJatek8Ertekeles() {
        return jatek8Ertekeles;
    }

    /**
     * Beállítja a 8. játékértékelés étékét.
     *
     * @param jatek8Ertekeles a 8. játék értékelése
     */
    public void setJatek8Ertekeles(int jatek8Ertekeles) {
        this.jatek8Ertekeles = jatek8Ertekeles;
    }

    /**
     * lekéri a 9. játék nevét.
     *
     * @return visszatér a 9. játék nevével
     */
    public String getJatek9() {
        return jatek9;
    }

    /**
     * beállítja a 9. játék nevét.
     *
     * @param jatek9 a 9. játék nevét várja
     */
    public void setJatek9(String jatek9) {
        this.jatek9 = jatek9;
    }

    /**
     * Lekéri a 9. játékértékelés értékét.
     *
     * @return visszatér a 9. játék értékelésével
     */
    public int getJatek9Ertekeles() {
        return jatek9Ertekeles;
    }

    /**
     * Beállítja a 9. játékértékelés étékét.
     *
     * @param jatek9Ertekeles a 9. játék értékelése
     */
    public void setJatek9Ertekeles(int jatek9Ertekeles) {
        this.jatek9Ertekeles = jatek9Ertekeles;
    }

    /**
     * lekéri a 10. játék nevét.
     *
     * @return visszatér a 10. játék nevével
     */
    public String getJatek10() {
        return jatek10;
    }

    /**
     * beállítja a 10. játék nevét.
     *
     * @param jatek10 a 10. játék nevét várja
     */
    public void setJatek10(String jatek10) {
        this.jatek10 = jatek10;
    }

    /**
     * Lekéri a 10. játékértékelés értékét.
     *
     * @return visszatér a 10. játék értékelésével
     */
    public int getJatek10Ertekeles() {
        return jatek10Ertekeles;
    }

    /**
     * Beállítja a 10. játékértékelés étékét.
     *
     * @param jatek10Ertekeles a 10. játék értékelése
     */
    public void setJatek10Ertekeles(int jatek10Ertekeles) {
        this.jatek10Ertekeles = jatek10Ertekeles;
    }

    /**
     * lekéri a 11. játék nevét.
     *
     * @return visszatér a 11. játék nevével
     */
    public String getJatek11() {
        return jatek11;
    }

    /**
     * beállítja a 11. játék nevét.
     *
     * @param jatek11 a 11. játék nevét várja
     */
    public void setJatek11(String jatek11) {
        this.jatek11 = jatek11;
    }

    /**
     * Lekéri a 11. játékértékelés értékét.
     *
     * @return visszatér a 11. játék értékelésével
     */
    public int getJatek11Ertekeles() {
        return jatek11Ertekeles;
    }

    /**
     * Beállítja a 11. játékértékelés étékét.
     *
     * @param jatek11Ertekeles a 11. játék értékelése
     */
    public void setJatek11Ertekeles(int jatek11Ertekeles) {
        this.jatek11Ertekeles = jatek11Ertekeles;
    }

    /**
     * lekéri a 12. játék nevét.
     *
     * @return visszatér a 12. játék nevével
     */
    public String getJatek12() {
        return jatek12;
    }

    /**
     * beállítja a 12. játék nevét.
     *
     * @param jatek12 a 12. játék nevét várja
     */
    public void setJatek12(String jatek12) {
        this.jatek12 = jatek12;
    }

    /**
     * Lekéri a 12. játékértékelés értékét.
     *
     * @return visszatér a 12. játék értékelésével
     */
    public int getJatek12Ertekeles() {
        return jatek12Ertekeles;
    }

    /**
     * Beállítja a 12. játékértékelés étékét.
     *
     * @param jatek12Ertekeles a 12. játék értékelése
     */
    public void setJatek12Ertekeles(int jatek12Ertekeles) {
        this.jatek12Ertekeles = jatek12Ertekeles;
    }

    /**
     * lekéri a 13. játék nevét.
     *
     * @return visszatér a 13. játék nevével
     */
    public String getJatek13() {
        return jatek13;
    }

    /**
     * beállítja a 13. játék nevét.
     *
     * @param jatek13 a 13. játék nevét várja
     */
    public void setJatek13(String jatek13) {
        this.jatek13 = jatek13;
    }

    /**
     * Lekéri a 13. játékértékelés értékét.
     *
     * @return visszatér a 13. játék értékelésével
     */
    public int getJatek13Ertekeles() {
        return jatek13Ertekeles;
    }

    /**
     * Beállítja a 13. játékértékelés étékét.
     *
     * @param jatek13Ertekeles a 13. játék értékelése
     */
    public void setJatek13Ertekeles(int jatek13Ertekeles) {
        this.jatek13Ertekeles = jatek13Ertekeles;
    }

    /**
     * lekéri a 14. játék nevét.
     *
     * @return visszatér a 14. játék nevével
     */
    public String getJatek14() {
        return jatek14;
    }

    /**
     * beállítja a 14. játék nevét.
     *
     * @param jatek14 a 14. játék nevét várja
     */
    public void setJatek14(String jatek14) {
        this.jatek14 = jatek14;
    }

    /**
     * Lekéri a 14. játékértékelés értékét.
     *
     * @return visszatér a 14. játék értékelésével
     */
    public int getJatek14Ertekeles() {
        return jatek14Ertekeles;
    }

    /**
     * Beállítja a 14. játékértékelés étékét.
     *
     * @param jatek14Ertekeles a 14. játék értékelése
     */
    public void setJatek14Ertekeles(int jatek14Ertekeles) {
        this.jatek14Ertekeles = jatek14Ertekeles;
    }

    /**
     * lekéri a 15. játék nevét.
     *
     * @return visszatér a 15. játék nevével
     */
    public String getJatek15() {
        return jatek15;
    }

    /**
     * beállítja a 15. játék nevét.
     *
     * @param jatek15 a 15. játék nevét várja
     */
    public void setJatek15(String jatek15) {
        this.jatek15 = jatek15;
    }

    /**
     * Lekéri a 15. játékértékelés értékét.
     *
     * @return visszatér a 15. játék értékelésével
     */
    public int getJatek15Ertekeles() {
        return jatek15Ertekeles;
    }

    /**
     * Beállítja a 15. játékértékelés étékét.
     *
     * @param jatek15Ertekeles a 15. játék értékelése
     */
    public void setJatek15Ertekeles(int jatek15Ertekeles) {
        this.jatek15Ertekeles = jatek15Ertekeles;
    }

    private String userName;
    private String jatek1;
    private int jatek1Ertekeles;
    private String jatek2;
    private int jatek2Ertekeles;
    private String jatek3;
    private int jatek3Ertekeles;
    private String jatek4;
    private int jatek4Ertekeles;
    private String jatek5;
    private int jatek5Ertekeles;
    private String jatek6;
    private int jatek6Ertekeles;
    private String jatek7;
    private int jatek7Ertekeles;
    private String jatek8;
    private int jatek8Ertekeles;
    private String jatek9;
    private int jatek9Ertekeles;
    private String jatek10;
    private int jatek10Ertekeles;
    private String jatek11;
    private int jatek11Ertekeles;
    private String jatek12;
    private int jatek12Ertekeles;
    private String jatek13;
    private int jatek13Ertekeles;
    private String jatek14;
    private int jatek14Ertekeles;
    private String jatek15;
    private int jatek15Ertekeles;


    /**
     * visszaadja a játék nevét azonosító alapján.
     *
     * @param id azonosító
     * @return a játék neve
     */
    @Transient
    public String jatekById(int id) {
        if (id == 1) {
            return getJatek1();
        } else if (id == 2) {
            return getJatek2();
        } else if (id == 3) {
            return getJatek3();
        } else if (id == 4) {
            return getJatek4();
        } else if (id == 5) {
            return getJatek5();
        } else if (id == 6) {
            return getJatek6();
        } else if (id == 7) {
            return getJatek7();
        } else if (id == 8) {
            return getJatek8();
        } else if (id == 9) {
            return getJatek9();
        } else if (id == 10) {
            return getJatek10();
        } else if (id == 11) {
            return getJatek11();
        } else if (id == 12) {
            return getJatek12();
        } else if (id == 13) {
            return getJatek13();
        } else if (id == 14) {
            return getJatek14();
        } else if (id == 15) {
            return getJatek15();
        }
        return null;
    }

    /**
     * visszaadja a játék értékeléseket azonosító alapján.
     *
     * @param id azonosító
     * @return játék értékelés
     */
    @Transient
    public int jatekErtekelesById(int id) {
        if (id == 1) {
            return getJatek1Ertekeles();
        } else if (id == 2) {
            return getJatek2Ertekeles();
        } else if (id == 3) {
            return getJatek3Ertekeles();
        } else if (id == 4) {
            return getJatek4Ertekeles();
        } else if (id == 5) {
            return getJatek5Ertekeles();
        } else if (id == 6) {
            return getJatek6Ertekeles();
        } else if (id == 7) {
            return getJatek7Ertekeles();
        } else if (id == 8) {
            return getJatek8Ertekeles();
        } else if (id == 9) {
            return getJatek9Ertekeles();
        } else if (id == 10) {
            return getJatek10Ertekeles();
        } else if (id == 11) {
            return getJatek11Ertekeles();
        } else if (id == 12) {
            return getJatek12Ertekeles();
        } else if (id == 13) {
            return getJatek13Ertekeles();
        } else if (id == 14) {
            return getJatek14Ertekeles();
        } else if (id == 15) {
            return getJatek15Ertekeles();
        }
        return -1;
    }

    /**
     * lekéri az összejáték nevét.
     *
     * @return játéknevek
     */
    @Transient
    public List<String> getOsszesJatekNev(){
        List<String> list = new ArrayList<>();
        list.add(this.jatek1);
        list.add(this.jatek2);
        list.add(this.jatek3);
        list.add(this.jatek4);
        list.add(this.jatek5);
        list.add(this.jatek6);
        list.add(this.jatek7);
        list.add(this.jatek8);
        list.add(this.jatek9);
        list.add(this.jatek10);
        list.add(this.jatek11);
        list.add(this.jatek12);
        list.add(this.jatek13);
        list.add(this.jatek14);
        list.add(this.jatek15);
        return list;
    }

    /**
     * lekéri az összes játékértékelést.
     *
     * @return játékértékelések
     */
    @Transient
    public List<Integer> getOsszesJatekErtekeles(){
        List<Integer> list = new ArrayList<>();
        list.add(this.jatek1Ertekeles);
        list.add(this.jatek2Ertekeles);
        list.add(this.jatek3Ertekeles);
        list.add(this.jatek4Ertekeles);
        list.add(this.jatek5Ertekeles);
        list.add(this.jatek6Ertekeles);
        list.add(this.jatek7Ertekeles);
        list.add(this.jatek8Ertekeles);
        list.add(this.jatek9Ertekeles);
        list.add(this.jatek10Ertekeles);
        list.add(this.jatek11Ertekeles);
        list.add(this.jatek12Ertekeles);
        list.add(this.jatek13Ertekeles);
        list.add(this.jatek14Ertekeles);
        list.add(this.jatek15Ertekeles);
        return list;
    }
}
