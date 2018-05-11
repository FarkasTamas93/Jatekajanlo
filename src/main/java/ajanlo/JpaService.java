package ajanlo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Farkas Tamas on 2017.12.30..
 */

/**
 * singleton osztály amely az adatbázisokhoz biztosít kapcsolatot.
 *
 */
public class JpaService {

    private static JpaService jpaServiceInstance = new JpaService();

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    /**
     * lekéri a JatekokServiceJPA értékét.
     *
     * @return visszatér a JatekokServiceJPA értékével
     */
    public JatekokServiceJPA getJatekokServiceJPA() {
        return jatekokServiceJPA;
    }

    /**
     * beállítja a JatekokServiceJPA értékét.
     *
     * @param jatekokServiceJPA a JatekokServiceJPA értékét várja
     */
    public void setJatekokServiceJPA(JatekokServiceJPA jatekokServiceJPA) {
        this.jatekokServiceJPA = jatekokServiceJPA;
    }

    /**
     * lekéri a JatekValasztasServiceJPA értékét.
     *
     * @return a JatekValasztasServiceJPA értékével tér vissza
     */
    public JatekvalasztasServiceJPA getJatekvalasztasServiceJPA() {
        return jatekvalasztasServiceJPA;
    }

    /**
     * beállítja a JatekValasztasServiceJPA értékét.
     *
     * @param jatekvalasztasServiceJPA a JatekValasztasServiceJPA értékét várja
     */
    public void setJatekvalasztasServiceJPA(JatekvalasztasServiceJPA jatekvalasztasServiceJPA) {
        this.jatekvalasztasServiceJPA = jatekvalasztasServiceJPA;
    }

    private JatekokServiceJPA jatekokServiceJPA = null;
    private JatekvalasztasServiceJPA jatekvalasztasServiceJPA = null;

    /**
     * Lekéri a JpaServiceInstance értékét.
     *
     * @return a JpaServiceInstance értékével tér vissza
     */
    public static JpaService getJpaServiceInstance() {
        return jpaServiceInstance;
    }

    /**
     * lekéri az EntityManagerFactory értékét.
     *
     * @return az EntityManagerFactory értékével tér vissza
     */
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    /**
     * beállítja az entityManagerFactory értékét.
     *
     * @param entityManagerFactory az EntityManagerFactory értékét várja
     */
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    /**
     * lekéri az entityManager értékét.
     *
     * @return visszatér az entotyManager érétkével
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * beállítja az entityManager értékét.
     *
     * @param entityManager az entityManager értékét várja
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
