package ajanlo.optimalisKereso;

import ajanlo.model.Jatekok;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */
public class JatekokNeveEsAra {

    private List<Jatekok> jatekok = new ArrayList<>();

    private static JatekokNeveEsAra instance = new JatekokNeveEsAra();

    public static JatekokNeveEsAra getInstance() {
        return instance;
    }

    private JatekokNeveEsAra(){

    }

    public List<Jatekok> getJatekok() {
        return jatekok;
    }

    public void setJatekok(List<Jatekok> jatekok) {
        this.jatekok = jatekok;
    }
}
