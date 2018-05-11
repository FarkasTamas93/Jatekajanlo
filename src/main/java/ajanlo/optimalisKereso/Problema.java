package ajanlo.optimalisKereso;

import ajanlo.KlaszterezettJatekokService;
import ajanlo.model.Jatekok;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Farkas Tamas on 2018.01.03..
 */

/**
 * A proléma reprezentációja, mely megadja a kezdőállapotot és létrehozza az operátorok listáját.
 *
 */
public class Problema {

    /**
     * a kezdőállapot létrehozása.
     *
     * @return visszatér egy új állapottal, melynek kezdőértékei beállítódnak.
     */
    public Allapot kezdo() {
        return new Allapot();
    }
/*
    static List<Operator> OPERATOROK = new ArrayList<Operator>();

    static {
        List<Jatekok> jatekok = JatekokNeveEsAra.getInstance().getJatekok();
        Map<String,Double> klaszterezettjatekok = KlaszterezettJatekokService.getKlaszterezettJatekokService().getJatekokAtlagErtekelese();
        List<String> klaszterezettJatekokNeve = new ArrayList<>();
        for(Map.Entry map : klaszterezettjatekok.entrySet()){
            klaszterezettJatekokNeve.add(map.getKey().toString());
        }

        for(int i=0;i<jatekok.size();i++){
            for(int j=0;j<klaszterezettJatekokNeve.size();j++){
                if(jatekok.get(i).getNev().equals(klaszterezettJatekokNeve.get(j))){
                    OPERATOROK.add(new Operator(jatekok.get(i).getNev(),jatekok.get(i).getAr(),klaszterezettjatekok.get(jatekok.get(i).getNev())));
                }
            }
        }
    }
*/
    List<Operator> OPERATOROK = new ArrayList<Operator>();

    {
        List<Jatekok> jatekok = JatekokNeveEsAra.getInstance().getJatekok();
        Map<String,Double> klaszterezettjatekok = KlaszterezettJatekokService.getKlaszterezettJatekokService().getJatekokAtlagErtekelese();
        List<String> klaszterezettJatekokNeve = new ArrayList<>();
        for(Map.Entry map : klaszterezettjatekok.entrySet()){
            klaszterezettJatekokNeve.add(map.getKey().toString());
        }

        for(int i=0;i<jatekok.size();i++){
            for(int j=0;j<klaszterezettJatekokNeve.size();j++){
                if(jatekok.get(i).getNev().equals(klaszterezettJatekokNeve.get(j))){
                    OPERATOROK.add(new Operator(jatekok.get(i).getNev(),jatekok.get(i).getAr(),klaszterezettjatekok.get(jatekok.get(i).getNev())));
                }
            }
        }
    }

    /**
     * lekéri az operátorokat.
     *
     * @return visszatér az  operátorlistával.
     */
    public List<Operator> operatorok() {
        return OPERATOROK;
    }

}
