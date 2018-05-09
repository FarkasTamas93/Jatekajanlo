package ajanlo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farkas Tamas on 2017.12.29..
 */

@Entity
public class Jatekvalasztas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Jatekvalasztas() {
    }

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

    public int getJatek5Ertekeles() {
        return jatek5Ertekeles;
    }

    public void setJatek5Ertekeles(int jatek5Ertekeles) {
        this.jatek5Ertekeles = jatek5Ertekeles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJatek1() {
        return jatek1;
    }

    public void setJatek1(String jatek1) {
        this.jatek1 = jatek1;
    }

    public int getJatek1Ertekeles() {
        return jatek1Ertekeles;
    }

    public void setJatek1Ertekeles(int jatek1Ertekeles) {
        this.jatek1Ertekeles = jatek1Ertekeles;
    }

    public String getJatek2() {
        return jatek2;
    }

    public void setJatek2(String jatek2) {
        this.jatek2 = jatek2;
    }

    public int getJatek2Ertekeles() {
        return jatek2Ertekeles;
    }

    public void setJatek2Ertekeles(int jatek2Ertekeles) {
        this.jatek2Ertekeles = jatek2Ertekeles;
    }

    public String getJatek3() {
        return jatek3;
    }

    public void setJatek3(String jatek3) {
        this.jatek3 = jatek3;
    }

    public int getJatek3Ertekeles() {
        return jatek3Ertekeles;
    }

    public void setJatek3Ertekeles(int jatek3Ertekeles) {
        this.jatek3Ertekeles = jatek3Ertekeles;
    }

    public String getJatek4() {
        return jatek4;
    }

    public void setJatek4(String jatek4) {
        this.jatek4 = jatek4;
    }

    public int getJatek4Ertekeles() {
        return jatek4Ertekeles;
    }

    public void setJatek4Ertekeles(int jatek4Ertekeles) {
        this.jatek4Ertekeles = jatek4Ertekeles;
    }

    public String getJatek5() {
        return jatek5;
    }

    public void setJatek5(String jatek5) {
        this.jatek5 = jatek5;
    }

    public String getJatek6() {
        return jatek6;
    }

    public void setJatek6(String jatek6) {
        this.jatek6 = jatek6;
    }

    public int getJatek6Ertekeles() {
        return jatek6Ertekeles;
    }

    public void setJatek6Ertekeles(int jatek6Ertekeles) {
        this.jatek6Ertekeles = jatek6Ertekeles;
    }

    public String getJatek7() {
        return jatek7;
    }

    public void setJatek7(String jatek7) {
        this.jatek7 = jatek7;
    }

    public int getJatek7Ertekeles() {
        return jatek7Ertekeles;
    }

    public void setJatek7Ertekeles(int jatek7Ertekeles) {
        this.jatek7Ertekeles = jatek7Ertekeles;
    }

    public String getJatek8() {
        return jatek8;
    }

    public void setJatek8(String jatek8) {
        this.jatek8 = jatek8;
    }

    public int getJatek8Ertekeles() {
        return jatek8Ertekeles;
    }

    public void setJatek8Ertekeles(int jatek8Ertekeles) {
        this.jatek8Ertekeles = jatek8Ertekeles;
    }

    public String getJatek9() {
        return jatek9;
    }

    public void setJatek9(String jatek9) {
        this.jatek9 = jatek9;
    }

    public int getJatek9Ertekeles() {
        return jatek9Ertekeles;
    }

    public void setJatek9Ertekeles(int jatek9Ertekeles) {
        this.jatek9Ertekeles = jatek9Ertekeles;
    }

    public String getJatek10() {
        return jatek10;
    }

    public void setJatek10(String jatek10) {
        this.jatek10 = jatek10;
    }

    public int getJatek10Ertekeles() {
        return jatek10Ertekeles;
    }

    public void setJatek10Ertekeles(int jatek10Ertekeles) {
        this.jatek10Ertekeles = jatek10Ertekeles;
    }

    public String getJatek11() {
        return jatek11;
    }

    public void setJatek11(String jatek11) {
        this.jatek11 = jatek11;
    }

    public int getJatek11Ertekeles() {
        return jatek11Ertekeles;
    }

    public void setJatek11Ertekeles(int jatek11Ertekeles) {
        this.jatek11Ertekeles = jatek11Ertekeles;
    }

    public String getJatek12() {
        return jatek12;
    }

    public void setJatek12(String jatek12) {
        this.jatek12 = jatek12;
    }

    public int getJatek12Ertekeles() {
        return jatek12Ertekeles;
    }

    public void setJatek12Ertekeles(int jatek12Ertekeles) {
        this.jatek12Ertekeles = jatek12Ertekeles;
    }

    public String getJatek13() {
        return jatek13;
    }

    public void setJatek13(String jatek13) {
        this.jatek13 = jatek13;
    }

    public int getJatek13Ertekeles() {
        return jatek13Ertekeles;
    }

    public void setJatek13Ertekeles(int jatek13Ertekeles) {
        this.jatek13Ertekeles = jatek13Ertekeles;
    }

    public String getJatek14() {
        return jatek14;
    }

    public void setJatek14(String jatek14) {
        this.jatek14 = jatek14;
    }

    public int getJatek14Ertekeles() {
        return jatek14Ertekeles;
    }

    public void setJatek14Ertekeles(int jatek14Ertekeles) {
        this.jatek14Ertekeles = jatek14Ertekeles;
    }

    public String getJatek15() {
        return jatek15;
    }

    public void setJatek15(String jatek15) {
        this.jatek15 = jatek15;
    }

    public int getJatek15Ertekeles() {
        return jatek15Ertekeles;
    }

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
