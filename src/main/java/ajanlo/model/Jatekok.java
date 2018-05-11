package ajanlo.model;

import javax.persistence.*;

/**
 * Created by Farkas Tamas on 2017.12.30..
 */

/**
 * Entity osztály a játékokhoz.
 *
 */
@Entity
public class Jatekok {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nev;
    private int ar;

    /**
     * paraméter nélküli kontruktor.
     *
     */
    public Jatekok() {
    }

    /**
     * két paraméteres konstruktor.
     *
     * @param nev A játék neve
     * @param ar a játék ára
     */
    public Jatekok(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
    }

    /**
     * lekéri az azonosítót.
     *
     * @return visszatér az azonosítóval
     */
    public int getId() {
        return id;
    }

    /**
     * beállítja az azonosítót.
     *
     * @param id az azonosító számot várja
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * lekéri a játék nevet.
     *
     * @return visszatér a játék nevével
     */
    public String getNev() {
        return nev;
    }

    /**
     * beállítja a játék nevét.
     *
     * @param nev a játék nevét várja
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * lekéri a játék árát.
     *
     * @return visszatér a játék árával
     */
    public int getAr() {
        return ar;
    }

    /**
     * beállítja a játék árát.
     *
     * @param ar a játék árát várja
     */
    public void setAr(int ar) {
        this.ar = ar;
    }
}
