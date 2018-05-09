package ajanlo;

import ajanlo.model.Jatekok;
import ajanlo.model.Jatekvalasztas;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Farkas Tamas on 2017.12.30..
 */
public class JatekvalasztasServiceJPA {

    EntityManager entityManager;

    /**
     * Egy paraméteres konstruktor.
     *
     * @param entityManager
     */
    public JatekvalasztasServiceJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * A véletlenszerű játékértékeléseket töltö fel az adatbázisba.
     *
     * @param jatekosNev A játékos neve
     * @param jatek1 az 1. játék neve amit értékel
     * @param ertekeles1 az 1. játék értékelése
     * @param jatek2 a 2. játék neve amit értékel
     * @param ertekeles2 a 2. játék értékelése
     * @param jatek3 a 3. játék neve amit értékel
     * @param ertekeles3 a 3. játék értékelése
     * @param jatek4 a 4.játék neve amit értékel
     * @param ertekeles4 a 4. játék értékelése
     * @param jatek5  az 5. játék neve amit értékel
     * @param ertekeles5 az 5. játék értékelése
     * @param jatek6 a 6. játék neve amit értékel
     * @param ertekeles6 a 6. játék értékelése
     * @param jatek7 a 7. játék neve amit értékel
     * @param ertekeles7 a 7. játék értékelése
     * @param jatek8 a 8. játék neve amit értékel
     * @param ertekeles8 a 8. játék értékelése
     * @param jatek9 a 9. játék neve amit értékel
     * @param ertekeles9 a 9. játék értékelése
     * @param jatek10 a 10. játék neve amit értékel
     * @param ertekeles10 a 10. játék értékelése
     * @param jatek11 a 11. játék neve amit értékel
     * @param ertekeles11 a 11. játék értékelése
     * @param jatek12 a 12.  játék neve amit értékel
     * @param ertekeles12 a 12. játék értékelése
     * @param jatek13 a 13. játék neve amit értékel
     * @param ertekeles13 a 13. játék értékelése
     * @param jatek14 a 14. játék neve amit értékel
     * @param ertekeles14 a 14. játék értékelése
     * @param jatek15 a 15. játék neve amit értékel
     * @param ertekeles15 a 15. játék értékelése
     * @return egy jatekvalasztas egyeddel tér vissza
     */
    public Jatekvalasztas jatekErtekelesAdatbazisba(String jatekosNev,String jatek1,int ertekeles1,String jatek2,int ertekeles2,String jatek3,int ertekeles3,String jatek4,int ertekeles4,String jatek5,int ertekeles5,String jatek6,int ertekeles6,String jatek7,int ertekeles7,String jatek8,int ertekeles8,String jatek9,int ertekeles9,String jatek10,int ertekeles10,String jatek11,int ertekeles11,String jatek12,int ertekeles12,String jatek13,int ertekeles13,String jatek14,int ertekeles14,String jatek15,int ertekeles15) {
        Jatekvalasztas jatekErtekelesToDatabase = new Jatekvalasztas();
        try {
            entityManager.getTransaction().begin();
            jatekErtekelesToDatabase.setUserName(jatekosNev);
            jatekErtekelesToDatabase.setJatek1(jatek1);
            jatekErtekelesToDatabase.setJatek1Ertekeles(ertekeles1);
            jatekErtekelesToDatabase.setJatek2(jatek2);
            jatekErtekelesToDatabase.setJatek2Ertekeles(ertekeles2);
            jatekErtekelesToDatabase.setJatek3(jatek3);
            jatekErtekelesToDatabase.setJatek3Ertekeles(ertekeles3);
            jatekErtekelesToDatabase.setJatek4(jatek4);
            jatekErtekelesToDatabase.setJatek4Ertekeles(ertekeles4);
            jatekErtekelesToDatabase.setJatek5(jatek5);
            jatekErtekelesToDatabase.setJatek5Ertekeles(ertekeles5);
            jatekErtekelesToDatabase.setJatek6(jatek6);
            jatekErtekelesToDatabase.setJatek6Ertekeles(ertekeles6);
            jatekErtekelesToDatabase.setJatek7(jatek7);
            jatekErtekelesToDatabase.setJatek7Ertekeles(ertekeles7);
            jatekErtekelesToDatabase.setJatek8(jatek8);
            jatekErtekelesToDatabase.setJatek8Ertekeles(ertekeles8);
            jatekErtekelesToDatabase.setJatek9(jatek9);
            jatekErtekelesToDatabase.setJatek9Ertekeles(ertekeles9);
            jatekErtekelesToDatabase.setJatek10(jatek10);
            jatekErtekelesToDatabase.setJatek10Ertekeles(ertekeles10);
            jatekErtekelesToDatabase.setJatek11(jatek11);
            jatekErtekelesToDatabase.setJatek11Ertekeles(ertekeles11);
            jatekErtekelesToDatabase.setJatek12(jatek12);
            jatekErtekelesToDatabase.setJatek12Ertekeles(ertekeles12);
            jatekErtekelesToDatabase.setJatek13(jatek13);
            jatekErtekelesToDatabase.setJatek13Ertekeles(ertekeles13);
            jatekErtekelesToDatabase.setJatek14(jatek14);
            jatekErtekelesToDatabase.setJatek14Ertekeles(ertekeles14);
            jatekErtekelesToDatabase.setJatek15(jatek15);
            jatekErtekelesToDatabase.setJatek15Ertekeles(ertekeles15);
            entityManager.persist(jatekErtekelesToDatabase);
            entityManager.getTransaction().commit();
        }catch (EntityExistsException | IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        return jatekErtekelesToDatabase;
    }

    /**
     * Kiválasztja azokat a játékosokat, akik ugyan azt az 5 játékot biztosan  értékelték a 15 játékukból, mint az aktuális felhasználó.
     *
     * @param kiv1 a felhasználó által kiválasztott 1. játék
     * @param kiv2 a felhasználó által kiválasztott 2. játék
     * @param kiv3 a felhasználó által kiválasztott 3. játék
     * @param kiv4 a felhasználó által kiválasztott 4. játék
     * @param kiv5 a felhasználó által kiválasztott 5. játék
     * @return visszatér az eredménylistával.
     */
    public List<Jatekvalasztas> getHasonloJatekok(String kiv1,String kiv2,String kiv3,String kiv4,String kiv5) {
        Query query=null;
        try {
            query = entityManager.createNativeQuery("select * from jatekvalasztas where" +
                    " (binary jatek1 = binary'" + kiv1 + "' OR  jatek2 = binary'" + kiv1 + "' OR jatek3 = binary'" + kiv1 + "' OR jatek4 = binary'" + kiv1 + "' OR jatek5 = binary'" + kiv1 + "' OR  jatek6 = binary'" + kiv1 + "' OR  jatek7 = binary'" + kiv1 + "' OR  jatek8 = binary'" + kiv1 + "' OR  jatek9 = binary'" + kiv1 + "' OR  jatek10 = binary'" + kiv1 + "' OR  jatek11 = binary'" + kiv1 + "' OR  jatek12 = binary'" + kiv1 + "' OR  jatek13 = binary'" + kiv1 + "' OR  jatek14 = binary'" + kiv1 + "' OR  jatek15 = binary'" + kiv1 + "' ) AND" +
                    " (binary jatek1 = binary'" + kiv2 + "' OR  jatek2 = binary'" + kiv2 + "' OR jatek3 = binary'" + kiv2 + "' OR jatek4 = binary'" + kiv2 + "' OR jatek5 = binary'" + kiv2 + "' OR  jatek6 = binary'" + kiv2 + "' OR  jatek7 = binary'" + kiv2 + "' OR  jatek8 = binary'" + kiv2 + "' OR  jatek9 = binary'" + kiv2 + "' OR  jatek10 = binary'" + kiv2 + "' OR  jatek11 = binary'" + kiv2 + "' OR  jatek12 = binary'" + kiv2 + "' OR  jatek13 = binary'" + kiv2 + "' OR  jatek14 = binary'" + kiv2 + "' OR  jatek15 = binary'" + kiv2 + "' ) AND" +
                    " (binary jatek1 = binary'" + kiv3 + "' OR  jatek2 = binary'" + kiv3 + "' OR jatek3 = binary'" + kiv3 + "' OR jatek4 = binary'" + kiv3 + "' OR jatek5 = binary'" + kiv3 + "' OR  jatek6 = binary'" + kiv3 + "' OR  jatek7 = binary'" + kiv3 + "' OR  jatek8 = binary'" + kiv3 + "' OR  jatek9 = binary'" + kiv3 + "' OR  jatek10 = binary'" + kiv3 + "' OR  jatek11 = binary'" + kiv3 + "' OR  jatek12 = binary'" + kiv3 + "' OR  jatek13 = binary'" + kiv3 + "' OR  jatek14 = binary'" + kiv3 + "' OR  jatek15 = binary'" + kiv3 + "' ) AND" +
                    " (binary jatek1 = binary'" + kiv4 + "' OR  jatek2 = binary'" + kiv4 + "' OR jatek3 = binary'" + kiv4 + "' OR jatek4 = binary'" + kiv4 + "' OR jatek5 = binary'" + kiv4 + "' OR  jatek6 = binary'" + kiv4 + "' OR  jatek7 = binary'" + kiv4 + "' OR  jatek8 = binary'" + kiv4 + "' OR  jatek9 = binary'" + kiv4 + "' OR  jatek10 = binary'" + kiv4 + "' OR  jatek11 = binary'" + kiv4 + "' OR  jatek12 = binary'" + kiv4 + "' OR  jatek13 = binary'" + kiv4 + "' OR  jatek14 = binary'" + kiv4 + "' OR  jatek15 = binary'" + kiv4 + "' ) AND" +
                    " (binary jatek1 = binary'" + kiv5 + "' OR  jatek2 = binary'" + kiv5 + "' OR jatek3 = binary'" + kiv5 + "' OR jatek4 = binary'" + kiv5 + "' OR jatek5 = binary'" + kiv5 + "' OR  jatek6 = binary'" + kiv5 + "' OR  jatek7 = binary'" + kiv5 + "' OR  jatek8 = binary'" + kiv5 + "' OR  jatek9 = binary'" + kiv5 + "' OR  jatek10 = binary'" + kiv5 + "' OR  jatek11 = binary'" + kiv5 + "' OR  jatek12 = binary'" + kiv5 + "' OR  jatek13 = binary'" + kiv5 + "' OR  jatek14 = binary'" + kiv5 + "' OR  jatek15 = binary'" + kiv5 + "' )"
                    , Jatekvalasztas.class);
        }catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        return query.getResultList();
    }


}
