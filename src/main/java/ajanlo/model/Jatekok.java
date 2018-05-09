package ajanlo.model;

import javax.persistence.*;

/**
 * Created by Farkas Tamas on 2017.12.30..
 */

@Entity
public class Jatekok {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nev;
    private int ar;

    public Jatekok() {
    }

    public Jatekok(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
}
