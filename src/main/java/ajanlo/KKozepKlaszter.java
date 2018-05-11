package ajanlo;

import ajanlo.model.KlaszterezettJatekosok;
import ajanlo.model.Vec5KlaszterErtek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */

/**
 * Ez az osztály felel a teljes klaszterezési eljárásért,
 * magába foglal mindent, ami ehhez szükséges.
 *
 */
public class KKozepKlaszter {
    private int klaszterek_szama = 4;
    private int osszes_adat;

    private ArrayList<Data> adatok = new ArrayList<Data>();
    private ArrayList<Centroid> klaszterkozepek = new ArrayList<Centroid>();

    /**
     * Lekéri, hogy hány db klasztert kell létrehozni.
     *
     * @return visszatér a létrehozandó klaszterek számával
     */
    public int getKlaszterek_szama() {
        return klaszterek_szama;
    }

    /**
     * Beállítja, hogy hány klasztert kell létrehozni.
     *
     * @param klaszterek_szama a létrehozandó klaszterek számát várja
     */
    public void setKlaszterek_szama(int klaszterek_szama) {
        this.klaszterek_szama = klaszterek_szama;
    }

    /**
     * lekéri az összes adat értékét.
     *
     * @return visszatér az összes adat értékével
     */
    public int getOsszes_adat() {
        return osszes_adat;
    }

    /**
     * beállítja az összes adat érétkét.
     *
     * @param osszes_adat az összes adat értékét várja
     */
    public void setOsszes_adat(int osszes_adat) {
        this.osszes_adat = osszes_adat;
    }

    /**
     * lekéri az Adatok értékét.
     *
     * @return visszatér az Adatok értékével
     */
    public ArrayList<Data> getAdatok() {
        return adatok;
    }

    /**
     * Beállítja az Adatok értékét.
     *
     * @param adatok az Adatok értékét várja
     */
    public void setAdatok(ArrayList<Data> adatok) {
        this.adatok = adatok;
    }

    /**
     * Lekéri a beállított klaszterközepeket.
     *
     * @return visszatér a kiválasztott klaszterközepekkel
     */
    public ArrayList<Centroid> getKlaszterkozepek() {
        return klaszterkozepek;
    }

    /**
     * Beállítja a klaszterközepek értékét.
     *
     * @param klaszterkozepek a klaszterközepek értékét várja
     */
    public void setKlaszterkozepek(ArrayList<Centroid> klaszterkozepek) {
        this.klaszterkozepek = klaszterkozepek;
    }

    /**
     * A létrehozandó klaszterek számának megfelelően
     * előállít ugyan annyi véletlen számot, majd ezen számokat felhasználva
     * ezen indexeken lévő játékértékeléseket kiválasztja kezdő klaszterközépnek.
     *
     * @param ertekek azon kiszűrt játékosokat kapja meg, akiknek azon 5 játékértékelése van csak megtartva, amit a felhasználó is értékelt
     */
    public void initialize(List<Vec5KlaszterErtek> ertekek) {
        Random rand = new Random();
        List<Integer> randomSzamok = new ArrayList<>();
        int j = 0;
        while (j < klaszterek_szama) {
            int random = rand.nextInt(osszes_adat) + 0;
            if (randomSzamok.contains(random)) {
                continue;
            } else {
                randomSzamok.add(random);
                j++;
            }
        }

        for (int i = 0; i < klaszterek_szama; i++) {
            int k = randomSzamok.get(i);
            klaszterkozepek.add(new Centroid(ertekek.get(k).getJatek1Ertekeles(), ertekek.get(k).getJatek2Ertekeles(), ertekek.get(k).getJatek3Ertekeles(), ertekek.get(k).getJatek4Ertekeles(), ertekek.get(k).getJatek5Ertekeles()));
        }

//        for (int i = 0; i < klaszterkozepek.size(); i++) {
//            int k = randomSzamok.get(i);
//            System.out.println(klaszterkozepek.get(i).getX() + " " + klaszterkozepek.get(i).getY() + " " + klaszterkozepek.get(i).getZ() + " " + klaszterkozepek.get(i).getW() + " " + klaszterkozepek.get(i).getU() + " " + ertekek.get(k).getUser());
//        }
    }

    //Teszteleshez hasznalom

    /**
     * A teszteléshez választja ki a klaszterközepeket.
     *
     * @param ertekek 5 játék értékelését kapja meg felhasználónként
     */
    public void testInitialize(List<Vec5KlaszterErtek> ertekek) {

        for (int i = 0; i < klaszterek_szama; i++) {
            klaszterkozepek.add(new Centroid(ertekek.get(i).getJatek1Ertekeles(), ertekek.get(i).getJatek2Ertekeles(), ertekek.get(i).getJatek3Ertekeles(), ertekek.get(i).getJatek4Ertekeles(), ertekek.get(i).getJatek5Ertekeles()));
        }

    }

    /**
     * Elvégzi a klaszterezést. Euklideszi algoritmus segítségével távolságot számol a
     * klaszterközepek és a felhasználói értékelések között, amivel eldönti melyik
     * klaszterbe kerüljön a játékos, majd minden egyes játékos elhelyezését követően az adott
     * klaszter klaszterközepe újraszámolódik. Az utolsó  elem bekerülését követően
     * az elemeket újravizsgáljuk és amíg van mozgás a klaszterek között, addig folytatódik az algoritmus.
     *
     * @param ertekek azon kiszűrt játékosokat kapja meg, akiknek azon 5 játékértékelése van csak megtartva, amit a felhasználó is értékelt
     */
    public void kKozepKlaszterezes(List<Vec5KlaszterErtek> ertekek) {
//        Timer timer = new Timer();
        TimerNano timer = new TimerNano();
        timer.start();
        final double kezdoErtek = Math.pow(10, 10);
        double minimum = kezdoErtek;
        double tavolsag = 0.0;
        int klaszter = 0;
        boolean vanMozgas = true;
        Data newData = null;
        int k = 0;

        while (adatok.size() < osszes_adat) {
            newData = new Data(ertekek.get(k).getJatek1Ertekeles(), ertekek.get(k).getJatek2Ertekeles(), ertekek.get(k).getJatek3Ertekeles(), ertekek.get(k).getJatek4Ertekeles(), ertekek.get(k).getJatek5Ertekeles());
            adatok.add(newData);
            minimum = kezdoErtek;
            adatok.get(k).setUser(ertekek.get(k).getUser());
            for (int i = 0; i < klaszterek_szama; i++) {
                tavolsag = eukledesziTavolsag(newData, klaszterkozepek.get(i));
//                tavolsag = manhattanTavolsag(newData, klaszterkozepek.get(i));
                if (tavolsag < minimum) {
                    minimum = tavolsag;
                    klaszter = i;
                }
            }
            newData.cluster(klaszter);

            // calculate new centroids.
            for (int i = 0; i < klaszterek_szama; i++) {
                int totalX = 0;
                int totalY = 0;
                int totalZ = 0;
                int totalW = 0;
                int totalU = 0;
                int klaszterElemekSzama = 0;
                for (int j = 0; j < adatok.size(); j++) {
                    if (adatok.get(j).cluster() == i) {
                        totalX += adatok.get(j).getX();
                        totalY += adatok.get(j).getY();
                        totalZ += adatok.get(j).getZ();
                        totalW += adatok.get(j).getW();
                        totalU += adatok.get(j).getU();
                        klaszterElemekSzama++;
                    }
                }
                if (klaszterElemekSzama > 0) {
                    klaszterkozepek.get(i).setX(totalX / klaszterElemekSzama);
                    klaszterkozepek.get(i).setY(totalY / klaszterElemekSzama);
                    klaszterkozepek.get(i).setZ(totalZ / klaszterElemekSzama);
                    klaszterkozepek.get(i).setW(totalW / klaszterElemekSzama);
                    klaszterkozepek.get(i).setU(totalU / klaszterElemekSzama);
                }
            }
            k++;
        }

        while (vanMozgas) {
            // calculate new centroids.
            for (int i = 0; i < klaszterek_szama; i++) {
                int totalX = 0;
                int totalY = 0;
                int totalZ = 0;
                int totalW = 0;
                int totalU = 0;
                int klaszterElemekSzama = 0;
                for (int j = 0; j < adatok.size(); j++) {
                    if (adatok.get(j).cluster() == i) {
                        totalX += adatok.get(j).getX();
                        totalY += adatok.get(j).getY();
                        totalZ += adatok.get(j).getZ();
                        totalW += adatok.get(j).getW();
                        totalU += adatok.get(j).getU();
                        klaszterElemekSzama++;
                    }
                }
                if (klaszterElemekSzama > 0) {
                    klaszterkozepek.get(i).setX(totalX / klaszterElemekSzama);
                    klaszterkozepek.get(i).setY(totalY / klaszterElemekSzama);
                    klaszterkozepek.get(i).setZ(totalZ / klaszterElemekSzama);
                    klaszterkozepek.get(i).setW(totalW / klaszterElemekSzama);
                    klaszterkozepek.get(i).setU(totalU / klaszterElemekSzama);
                }
            }

            // Assign all data to the new centroids
            vanMozgas = false;

            for (int i = 0; i < adatok.size(); i++) {
                Data tempData = adatok.get(i);
                minimum = kezdoErtek;
                for (int j = 0; j < klaszterek_szama; j++) {
                    tavolsag = eukledesziTavolsag(tempData, klaszterkozepek.get(j));
//                    tavolsag = manhattanTavolsag(tempData, klaszterkozepek.get(j));
                    if (tavolsag < minimum) {
                        minimum = tavolsag;
                        klaszter = j;
                    }
                }
                tempData.cluster(klaszter);
                if (tempData.cluster() != klaszter) {
                    tempData.cluster(klaszter);
                    vanMozgas = true;
                }
            }
        }
        timer.end();
        System.out.println("Timer kklaszter:" + timer.getTotalTime());
//        for(int i=0;i<adatok.size();i++){
//            System.out.println(adatok.get(i).getX() + " " + adatok.get(i).getY() + " "+ adatok.get(i).getZ() + " "+ adatok.get(i).cluster() + " "+ adatok.get(i).getUser());
//        }
    }

    /**
     * Kiválasztásra kerülnek azok a játékosok, akik az aktuális felhasználóval azonos klaszterbe kerültek.
     *
     * @return visszatér a felhasználóval egy klaszterbe került játékosokkal
     */
    public List<KlaszterezettJatekosok> klaszterezettJatekosok() {
        Data ourData = new Data();
        for (int i = 0; i < adatok.size(); i++) {
            if (adatok.get(i).getUser().equals("newUser")) {
                ourData = adatok.get(i);
            }
        }

        List<KlaszterezettJatekosok> jatekosok = new ArrayList<>();
        for (int i = 0; i < adatok.size(); i++) {
            if (adatok.get(i).cluster() == ourData.cluster()) {
                jatekosok.add(new KlaszterezettJatekosok((int) adatok.get(i).getX(), (int) adatok.get(i).getY(), (int) adatok.get(i).getZ(), (int) adatok.get(i).getW(), (int) adatok.get(i).getU(), adatok.get(i).getUser(), adatok.get(i).cluster()));
            }
        }

        return jatekosok;
    }

    /**
     * Az Euklideszi távolság kiszámítását megvalósító függvény.
     *
     * @param d öt értékelést tartalmazó adat(egy játékos értékelései)
     * @param c egy klaszterközép
     * @return Az euklideszi tévolság értékével tér vissza
     */
    //Skalaris szorzat gyok alatt
    private double eukledesziTavolsag(Data d, Centroid c) {
        double newX = d.getX() - c.getX();
        double newY = d.getY() - c.getY();
        double newZ = d.getZ() - c.getZ();
        double neww = d.getW() - c.getW();
        double newu = d.getU() - c.getU();
        return Math.sqrt(newX * newX + newY * newY + newZ * newZ + neww * neww + newu * newu);
    }

    /**
     * Az Manhattan távolság kiszámítását megvalósító függvény.
     *
     * @param d öt értékelést tartalmazó adat(egy játékos értékelései)
     * @param c egy klaszterközép
     * @return Az Manhattan tévolság értékével tér vissza
     */
    private double manhattanTavolsag(Data d, Centroid c) {
        double newX = d.getX() - c.getX();
        double newY = d.getY() - c.getY();
        double newZ = d.getZ() - c.getZ();
        double neww = d.getW() - c.getW();
        double newu = d.getU() - c.getU();
        return Math.abs(newX) + Math.abs(newY) + Math.abs(newZ) + Math.abs(neww) + Math.abs(newu);
    }

    /**
     * Inner class. Arra szolgál, hogy megadjuk az értékelések struktúráját.
     *
     */
    private class Data {
        private double X = 0;
        private double Y = 0;
        private double Z = 0;
        private double W = 0;
        private double U = 0;

        private int mCluster = 0;
        private String user;

        /**
         * Inner class paraméter nélküli konstruktora.
         *
         */
        public Data() {

        }

        /**
         * Inner class több paraméteres konstruktora.
         *
         * @param x Az 1. játékértékelés
         * @param y A 2. játékértékelés
         * @param z A 3. játékértékelés
         * @param w A 4. játékértékelés
         * @param u Az 5. játékértékelés
         */
        public Data(double x, double y, double z, double w, double u) {
            this.setX(x);
            this.setY(y);
            this.setZ(z);
            this.setW(w);
            this.setU(u);
        }

        /**
         * Lekéri X érétkét.
         *
         * @return visszatér X értékével
         */
        public double getX() {
            return X;
        }

        /**
         * Beállítja X értékét.
         *
         * @param x X értékét várja
         */
        public void setX(double x) {
            X = x;
        }

        /**
         * Lekéri Y érétkét.
         *
         * @return visszatér Y értékével
         */
        public double getY() {
            return Y;
        }

        /**
         * Beállítja Y értékét.
         *
         * @param y Y értékét várja
         */
        public void setY(double y) {
            Y = y;
        }

        /**
         * Lekéri Z érétkét.
         *
         * @return visszatér Z értékével
         */
        public double getZ() {
            return Z;
        }

        /**
         * Beállítja Z értékét.
         *
         * @param z Z értékét várja
         */
        public void setZ(double z) {
            Z = z;
        }


        /**
         * Azt a klaszterszámot állítja be, amely bekerült az adott felhasználó.
         *
         * @param clusterNumber a klaszter számát várja
         */
        public void cluster(int clusterNumber) {
            this.mCluster = clusterNumber;
        }

        /**
         * Lekéri a klaszter számát, amibe a játékos került.
         *
         * @return visszatér a klaszter számával
         */
        public int cluster() {
            return this.mCluster;
        }


        /**
         * lekéri a felhasználó nevét.
         *
         * @return visszatér a felhasználó nevével
         */
        public String getUser() {
            return user;
        }

        /**
         * Beéllítja a felhasználó nevét.
         *
         * @param user a felhasználó nevét várja
         */
        public void setUser(String user) {
            this.user = user;
        }
        /**
         * Lekéri W érétkét.
         *
         * @return visszatér W értékével
         */
        public double getW() {
            return W;
        }

        /**
         * Beállítja W értékét.
         *
         * @param w W értékét várja
         */
        public void setW(double w) {
            W = w;
        }
        /**
         * Lekéri U érétkét.
         *
         * @return visszatér U értékével
         */
        public double getU() {
            return U;
        }
        /**
         * Beállítja U értékét.
         *
         * @param u U értékét várja
         */
        public void setU(double u) {
            U = u;
        }

        /**
         * Felülírt toString metódus az értékelések a klaszter száma és a felhasználó kiiratásához.
         *
         * @return
         */
        @Override
        public String toString() {
            return "Data{" +
                    "X=" + X +
                    ", Y=" + Y +
                    ", Z=" + Z +
                    ", W=" + W +
                    ", U=" + U +
                    ", mCluster=" + mCluster +
                    ", user='" + user + '\'' +
                    '}';
        }
    }

    /**
     * inner class, amely arra szolgál, hogy megadjuk a klaszterközepek struktúráját.
     *
     */
    private class Centroid {
        private double X = 0.0;
        private double Y = 0.0;
        private double Z = 0.0;
        private double W = 0.0;
        private double U = 0.0;

        /**
         * paraméter nélküli konstruktor.
         *
         */
        public Centroid() {

        }

        /**
         * többparaméteres konstruktor.
         *
         * @param x a klaszterközép 1. értékelése
         * @param y a klaszterközép 2. értékelése
         * @param z a klaszterközép 3. értékelése
         * @param w a klaszterközép 4. értékelése
         * @param u a klaszterközép 5. értékelése
         */
        public Centroid(double x, double y, double z, double w, double u) {
            this.setX(x);
            this.setY(y);
            this.setZ(z);
            this.setW(w);
            this.setU(u);
        }

        /**
         * Lekéri az X értékét.
         *
         * @return visszatér X érétkével
         */
        public double getX() {
            return X;
        }

        /**
         * Beállítja X értékét.
         *
         * @param x várja X értékét
         */
        public void setX(double x) {
            X = x;
        }
        /**
         * Lekéri az Y értékét.
         *
         * @return visszatér Y érétkével
         */
        public double getY() {
            return Y;
        }

        /**
         * Beállítja Y értékét.
         *
         * @param y várja Y értékét
         */
        public void setY(double y) {
            Y = y;
        }
        /**
         * Lekéri az Z értékét.
         *
         * @return visszatér Z érétkével
         */
        public double getZ() {
            return Z;
        }

        /**
         * Beállítja Z értékét.
         *
         * @param z várja Z értékét
         */
        public void setZ(double z) {
            Z = z;
        }
        /**
         * Lekéri az W értékét.
         *
         * @return visszatér W érétkével
         */
        public double getW() {
            return W;
        }
        /**
         * Beállítja W értékét.
         *
         * @param w várja W értékét
         */
        public void setW(double w) {
            W = w;
        }
        /**
         * Lekéri az U értékét.
         *
         * @return visszatér U érétkével
         */
        public double getU() {
            return U;
        }

        /**
         * Beállítja U értékét.
         *
         * @param u várja U értékét
         */
        public void setU(double u) {
            U = u;
        }

        /**
         * felülírt toString metódus a klaszterközép értékeinek kiírásához.
         *
         * @return
         */
        @Override
        public String toString() {
            return "Centroid{" +
                    "X=" + X +
                    ", Y=" + Y +
                    ", Z=" + Z +
                    ", W=" + W +
                    ", U=" + U +
                    '}';
        }
    }

}
