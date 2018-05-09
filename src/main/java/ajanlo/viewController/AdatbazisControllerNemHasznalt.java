package ajanlo.viewController;

/**
 * Created by Farkas Tamas on 2018.05.04..
 */
public class AdatbazisControllerNemHasznalt {

    /*
    @FXML
    private void uploadDatabase() {
        for(CheckBox cb : jatekok.keySet()){
            String jatekNeve = jatekok.get(cb).getText();
            Random random = new Random();
            int n = random.nextInt(15000) + 3000;
            System.out.println("jatek neve: "+ jatekNeve + "  ar: " + n);
            JpaService.getJpaServiceInstance().getJatekokServiceJPA().jatekLetrehozasAdatbazisba(jatekNeve,n);
        }
    }

     */

    /*
    @FXML
    private void jatekErtekelesek() {
        List<String> jateknevek = JpaService.getJpaServiceInstance().getJatekokServiceJPA().getAllJatekNev();
        Random rand = new Random();
        for(int i=220000;i<240000;i++){
            String nev = "player"+i;

            List<Integer> randomSzamok = new ArrayList<>();
            int j=0;
            while(j < 15) {
                int random = rand.nextInt(70)+0;
                if(randomSzamok.contains(random)){
                    continue;
                }else {
                    randomSzamok.add(random);
                    j++;
                }
            }
            List<String> kivlasztottJatekok = new ArrayList<>();
            for(int k=0;k<randomSzamok.size();k++){
                kivlasztottJatekok.add(jateknevek.get(randomSzamok.get(k)));
            }

            List<Integer> ertekelesek = new ArrayList<>();
            j=0;
            while(j < 15) {
                int random = rand.nextInt(5)+1;
                ertekelesek.add(random);
                j++;
            }

//          System.out.println("Jatekos neve: " + nev + " " + " jatek1: " + jatek1 + " ertekeles: " + ertekelesek.get(0) + " jatek2: " + jatek2 + " ertekeles: " + ertekelesek.get(1) + " jatek3: " + jatek3 + " ertekeles: " + ertekelesek.get(2) + " jatek4: " + jatek4 + " ertekeles: " + ertekelesek.get(3) +" jatek5: " + jatek5 + " ertekeles: " + ertekelesek.get(4));
//            JpaService.getJpaServiceInstance().getJatekvalasztasServiceJPA().jatekErtekelesAdatbazisba(nev,kivlasztottJatekok.get(0),ertekelesek.get(0),kivlasztottJatekok.get(1),ertekelesek.get(1),kivlasztottJatekok.get(2),ertekelesek.get(2),kivlasztottJatekok.get(3),ertekelesek.get(3),kivlasztottJatekok.get(4),ertekelesek.get(4),kivlasztottJatekok.get(5),ertekelesek.get(5),kivlasztottJatekok.get(6),ertekelesek.get(6),kivlasztottJatekok.get(7),ertekelesek.get(7),kivlasztottJatekok.get(8),ertekelesek.get(8),kivlasztottJatekok.get(9),ertekelesek.get(9),kivlasztottJatekok.get(10),ertekelesek.get(10),kivlasztottJatekok.get(11),ertekelesek.get(11),kivlasztottJatekok.get(12),ertekelesek.get(12),kivlasztottJatekok.get(13),ertekelesek.get(13),kivlasztottJatekok.get(14),ertekelesek.get(14));
        }
    }
     */

    /*
    @FXML
    private void jetekKereses(){
        List<Jatekvalasztas> osszes = new ArrayList<>();
//        osszes=JpaService.getJpaServiceInstance().getJatekvalasztasServiceJPA().getHasonloJatekok("Battlefield 1","Rayman","PES");
        for(Jatekvalasztas ossz : osszes){
            System.out.println(ossz.getId() + " " + ossz.getJatek1() + " " + ossz.getJatek2() + " "+ ossz.getJatek3() + " "+ ossz.getJatek4() + " "+ ossz.getJatek5() + " "+ ossz.getUserName() + " ");
        }
    }
     */
}
