package ajanlo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Farkas Tamas on 2017.12.30..
 */
public class JpaService {

    private static JpaService jpaServiceInstance = new JpaService();

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public JatekokServiceJPA getJatekokServiceJPA() {
        return jatekokServiceJPA;
    }

    public void setJatekokServiceJPA(JatekokServiceJPA jatekokServiceJPA) {
        this.jatekokServiceJPA = jatekokServiceJPA;
    }

    public JatekvalasztasServiceJPA getJatekvalasztasServiceJPA() {
        return jatekvalasztasServiceJPA;
    }

    public void setJatekvalasztasServiceJPA(JatekvalasztasServiceJPA jatekvalasztasServiceJPA) {
        this.jatekvalasztasServiceJPA = jatekvalasztasServiceJPA;
    }

    private JatekokServiceJPA jatekokServiceJPA = null;
    private JatekvalasztasServiceJPA jatekvalasztasServiceJPA = null;

    public static JpaService getJpaServiceInstance() {
        return jpaServiceInstance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
