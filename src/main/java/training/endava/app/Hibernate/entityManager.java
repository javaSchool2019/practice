package training.endava.app.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class entityManager {
    private static EntityManagerFactory entityManagerFactory = null;

    private entityManager(){
     entityManagerFactory=Persistence.createEntityManagerFactory("entityManager");
    }
    public static EntityManagerFactory getinstance() {
        if(entityManagerFactory == null)
        {
            new entityManager();
            return getinstance();
        }
        return entityManagerFactory;
    }
}
