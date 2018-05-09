/**
 * Created by Farkas Tamas on 2018.05.06..
 */

import ajanlo.KivalasztottJatekokService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KivalasztottJatekokServiceTest {

    @Test
    public void testNotNull(){
        assertTrue(KivalasztottJatekokService.getInstance() != null);
    }

    @Test
    public void testMaxNumber(){
        KivalasztottJatekokService.getInstance().addJatekNevek("Elso");
        KivalasztottJatekokService.getInstance().addJatekNevek("Masodik");
        KivalasztottJatekokService.getInstance().addJatekNevek("Harmadik");
        KivalasztottJatekokService.getInstance().addJatekNevek("Negyedik");
        KivalasztottJatekokService.getInstance().addJatekNevek("Otodik");
        KivalasztottJatekokService.getInstance().addJatekNevek("Hatodik");
        KivalasztottJatekokService.getInstance().addJatekNevek("Hetedik");
        assertTrue(KivalasztottJatekokService.getInstance().getJatekNevek().size() == 5);
    }

    @Test
    public void testRemoveGame(){
        KivalasztottJatekokService.getInstance().removeJatekNevek("Otodik");
        assertEquals("Negyedik", KivalasztottJatekokService.getInstance().getJatekNevek().get(KivalasztottJatekokService.getInstance().getJatekNevek().size() - 1));
    }

    @Test
    public void singletonTest(){
        KivalasztottJatekokService first = KivalasztottJatekokService.getInstance();
        KivalasztottJatekokService second = KivalasztottJatekokService.getInstance();
        System.out.println(first);
        System.out.println(second);
        assertTrue(first == second);
    }

}
