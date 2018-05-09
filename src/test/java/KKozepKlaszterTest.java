import ajanlo.KKozepKlaszter;
import ajanlo.KivalasztottJatekokService;
import ajanlo.model.Vec5KlaszterErtek;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Farkas Tamas on 2018.05.06..
 */
public class KKozepKlaszterTest {

    KKozepKlaszter testClass = new KKozepKlaszter();

    @Test
    public void testKlaszterekSzama() {
        assertTrue(4 == testClass.getKlaszterek_szama());
    }

    @Test
    public void testKlaszterKozepek0Elem() {
        assertEquals(0, testClass.getKlaszterkozepek().size());
    }

    @Test
    public void testInitialize() {
        List<Vec5KlaszterErtek> ertekek = new ArrayList<>();
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "A"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "B"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "C"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "D"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "E"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "F"));
        testClass.setOsszes_adat(ertekek.size());
        testClass.initialize(ertekek);
        assertTrue(testClass.getKlaszterkozepek().size() == testClass.getKlaszterek_szama());
    }

    @Test
    public void klaszterezesTest(){
        KKozepKlaszter temp = new KKozepKlaszter();
        List<Vec5KlaszterErtek> ertekek = new ArrayList<>();
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 5, "A"));
        ertekek.add(new Vec5KlaszterErtek(5, 2, 3, 4, 5, "B"));
        ertekek.add(new Vec5KlaszterErtek(2, 3, 3, 4, 5, "C"));
        ertekek.add(new Vec5KlaszterErtek(4, 2, 3, 4, 5, "D"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 3, 4, 4, "F"));
        ertekek.add(new Vec5KlaszterErtek(1, 2, 5, 4, 4, "G"));
        temp.setOsszes_adat(ertekek.size());
        temp.testInitialize(ertekek);
        temp.kKozepKlaszterezes(ertekek);
        System.out.println(temp.getKlaszterkozepek().get(0));
    }
}
