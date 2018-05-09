package ajanlo.viewController;

import ajanlo.KivalasztottJatekokService;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Farkas Tamas on 2018.05.04..
 */
public class KiiratasController {

    private static KiiratasController instance = new KiiratasController();

    public static KiiratasController getInstance() {
        return instance;
    }

    public void labelArrayInit(ArrayList<Label> labels,Label label1,Label label2,Label label3,Label label4,Label label5){
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
    }

    public void kivalasztottJatekokKiiratasa(int darab,ArrayList<Label> labels) {
        if(darab == 1) {
            labels.get(0).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(0));
        }

        if(darab == 2) {
            labels.get(0).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(0));
            labels.get(1).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(1));
        }


        if(darab == 3) {
            labels.get(0).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(0));
            labels.get(1).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(1));
            labels.get(2).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(2));
        }

        if(darab == 4) {
            labels.get(0).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(0));
            labels.get(1).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(1));
            labels.get(2).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(2));
            labels.get(3).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(3));
        }
        if(darab == 5) {
            labels.get(0).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(0));
            labels.get(1).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(1));
            labels.get(2).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(2));
            labels.get(3).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(3));
            labels.get(4).setText(KivalasztottJatekokService.getInstance().getJatekNevek().get(4));
        }
    }

    public void bepipalas(int darab,Map<CheckBox,Label> jatekok) {
        for(int i=0;i<darab;i++){
            for(CheckBox cb : jatekok.keySet()){
                String jatekNeve = jatekok.get(cb).getText();
                if(KivalasztottJatekokService.getInstance().getJatekNevek().get(i).equals(jatekNeve)){
                    cb.setSelected(true);
                }
            }
        }
    }

    public void checkboxKivalasztasKiiratas(ActionEvent event,Map<CheckBox,Label> jatekok,ArrayList<Label> labels){

        boolean benneVan = false;
        CheckBox bepipaltJatek = (CheckBox)event.getSource();
        String aktualisjatek = jatekok.get(bepipaltJatek).getText();
        for(int i=0;i<KivalasztottJatekokService.getInstance().getJatekNevek().size(); i++) {
            if(KivalasztottJatekokService.getInstance().getJatekNevek().get(i).equals(aktualisjatek))
                benneVan=true;
        }

        if(benneVan == false){
            if(bepipaltJatek.isSelected())
            {
                KivalasztottJatekokService.getInstance().addJatekNevek(aktualisjatek);
                for(int i=0;i<5;i++){
                    if(labels.get(i).getText().equals("")){
                        labels.get(i).setText(aktualisjatek);
                        break;
                    }
                }
                /*
                if(labels.get(0).getText().equals("")){
                    labels.get(0).setText(aktualisjatek);
                }else if(labels.get(1).getText().equals(""))
                    labels.get(1).setText(aktualisjatek);
                else if(labels.get(2).getText().equals(""))
                    labels.get(2).setText(aktualisjatek);
                else if(labels.get(3).getText().equals(""))
                    labels.get(3).setText(aktualisjatek);
                else if(labels.get(4).getText().equals(""))
                    labels.get(4).setText(aktualisjatek);
                */
            }else {
                KivalasztottJatekokService.getInstance().removeJatekNevek(aktualisjatek);
                for(int i=0;i<5;i++){
                    if(labels.get(i).getText().equals(aktualisjatek)){
                        labels.get(i).setText("");
                    }
                }
                /*
                if(labels.get(0).getText().equals(aktualisjatek))
                    labels.get(0).setText("");
                else if(labels.get(1).getText().equals(aktualisjatek))
                    labels.get(1).setText("");
                else if(labels.get(2).getText().equals(aktualisjatek))
                    labels.get(2).setText("");
                else if(labels.get(3).getText().equals(aktualisjatek))
                    labels.get(3).setText("");
                else if(labels.get(4).getText().equals(aktualisjatek))
                    labels.get(4).setText("");
                */
            }
        }else {
            KivalasztottJatekokService.getInstance().removeJatekNevek(aktualisjatek);
            for(int i=0;i<5;i++){
                if(labels.get(i).getText().equals(aktualisjatek)){
                    labels.get(i).setText("");
                }
            }
            /*
            if(labels.get(0).getText().equals(aktualisjatek))
                labels.get(0).setText("");
            else if(labels.get(1).getText().equals(aktualisjatek))
                labels.get(1).setText("");
            else if(labels.get(2).getText().equals(aktualisjatek))
                labels.get(2).setText("");
            else if(labels.get(3).getText().equals(aktualisjatek))
                labels.get(3).setText("");
            else if(labels.get(4).getText().equals(aktualisjatek))
                labels.get(4).setText("");
            */
        }

    }


}
