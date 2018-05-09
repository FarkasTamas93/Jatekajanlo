package ajanlo;

import ajanlo.model.KlaszterezettJatekosok;
import ajanlo.model.Vec5KlaszterErtek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Farkas Tamas on 2018.01.01..
 */
public class KKozepKlaszter {
    private int klaszterek_szama = 4;
    private int osszes_adat;

    private ArrayList<Data> adatok = new ArrayList<Data>();
    private ArrayList<Centroid> klaszterkozepek = new ArrayList<Centroid>();

    public int getKlaszterek_szama() {
        return klaszterek_szama;
    }

    public void setKlaszterek_szama(int klaszterek_szama) {
        this.klaszterek_szama = klaszterek_szama;
    }

    public int getOsszes_adat() {
        return osszes_adat;
    }

    public void setOsszes_adat(int osszes_adat) {
        this.osszes_adat = osszes_adat;
    }

    public ArrayList<Data> getAdatok() {
        return adatok;
    }

    public void setAdatok(ArrayList<Data> adatok) {
        this.adatok = adatok;
    }

    public ArrayList<Centroid> getKlaszterkozepek() {
        return klaszterkozepek;
    }

    public void setKlaszterkozepek(ArrayList<Centroid> klaszterkozepek) {
        this.klaszterkozepek = klaszterkozepek;
    }

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
    public void testInitialize(List<Vec5KlaszterErtek> ertekek) {

        for (int i = 0; i < klaszterek_szama; i++) {
            klaszterkozepek.add(new Centroid(ertekek.get(i).getJatek1Ertekeles(), ertekek.get(i).getJatek2Ertekeles(), ertekek.get(i).getJatek3Ertekeles(), ertekek.get(i).getJatek4Ertekeles(), ertekek.get(i).getJatek5Ertekeles()));
        }

    }

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

    //Skalaris szorzat gyok alatt
    private double eukledesziTavolsag(Data d, Centroid c) {
        double newX = d.getX() - c.getX();
        double newY = d.getY() - c.getY();
        double newZ = d.getZ() - c.getZ();
        double neww = d.getW() - c.getW();
        double newu = d.getU() - c.getU();
        return Math.sqrt(newX * newX + newY * newY + newZ * newZ + neww * neww + newu * newu);
    }

    private double manhattanTavolsag(Data d, Centroid c) {
        double newX = d.getX() - c.getX();
        double newY = d.getY() - c.getY();
        double newZ = d.getZ() - c.getZ();
        double neww = d.getW() - c.getW();
        double newu = d.getU() - c.getU();
        return Math.abs(newX) + Math.abs(newY) + Math.abs(newZ) + Math.abs(neww) + Math.abs(newu);
    }

    private class Data {
        private double X = 0;
        private double Y = 0;
        private double Z = 0;
        private double W = 0;
        private double U = 0;

        private int mCluster = 0;
        private String user;

        public Data() {

        }

        public Data(double x, double y, double z, double w, double u) {
            this.setX(x);
            this.setY(y);
            this.setZ(z);
            this.setW(w);
            this.setU(u);
        }

        public double getX() {
            return X;
        }

        public void setX(double x) {
            X = x;
        }

        public double getY() {
            return Y;
        }

        public void setY(double y) {
            Y = y;
        }

        public double getZ() {
            return Z;
        }

        public void setZ(double z) {
            Z = z;
        }

        public void cluster(int clusterNumber) {
            this.mCluster = clusterNumber;
        }

        public int cluster() {
            return this.mCluster;
        }


        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public double getW() {
            return W;
        }

        public void setW(double w) {
            W = w;
        }

        public double getU() {
            return U;
        }

        public void setU(double u) {
            U = u;
        }

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

    private class Centroid {
        private double X = 0.0;
        private double Y = 0.0;
        private double Z = 0.0;
        private double W = 0.0;
        private double U = 0.0;

        public Centroid() {

        }

        public Centroid(double x, double y, double z, double w, double u) {
            this.setX(x);
            this.setY(y);
            this.setZ(z);
            this.setW(w);
            this.setU(u);
        }

        public double getX() {
            return X;
        }

        public void setX(double x) {
            X = x;
        }

        public double getY() {
            return Y;
        }

        public void setY(double y) {
            Y = y;
        }

        public double getZ() {
            return Z;
        }

        public void setZ(double z) {
            Z = z;
        }

        public double getW() {
            return W;
        }

        public void setW(double w) {
            W = w;
        }

        public double getU() {
            return U;
        }

        public void setU(double u) {
            U = u;
        }

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
