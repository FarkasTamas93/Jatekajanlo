package ajanlo;

import ajanlo.model.Jatekok;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Farkas Tamas on 2017.12.30..
 */

/**
 * Singleton osztály amely az adatbázis műveleteket valósítja meg.
 *
 */
public class JatekokServiceJPA {

    EntityManager entityManager;

    /**
     * Egy paraméteres konstruktor.
     *
     * @param entityManager A JpaService entity manager-ét várja
     */
    public JatekokServiceJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * A játékok adatbázisának feltöltését biztosító metódus.
     *
     * @param name A játék neve.
     * @param ar a játék ára
     * @return egy Játékok példánnyal tér vissza.
     */
    public Jatekok jatekLetrehozasAdatbazisba(String name,int ar) {
        Jatekok jatekToDatabase = new Jatekok();
        try {
            entityManager.getTransaction().begin();
            jatekToDatabase.setNev(name);
            jatekToDatabase.setAr(ar);
            entityManager.persist(jatekToDatabase);
            entityManager.getTransaction().commit();
        }catch (EntityExistsException | IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        return jatekToDatabase;
    }

    /**
     * visszaadja az osszes jateknevet.
     *
     * @return visszatera query eredmennyel
     */
    public List<String> getAllJatekNev() {
        Query query = null;
        try {
            query = entityManager.createQuery("select e.nev from Jatekok e");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

    /**
     * Egy listát hoza létre a játékok adatbázis tartalmáról.
     *
     * @return visszatér az eredmény listával.
     */
    public List<Jatekok> getJatekok() {
        Query query = null;
        try {
            query = entityManager.createQuery("select e from Jatekok e");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

}
