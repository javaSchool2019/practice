package training.endava.app.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static final EntityManagerFactory entityManagerFactory;
    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getInstance(){
        if(entityManagerFactory == null){
            new EntityManagerUtil();
            return getInstance();
        }
        else{
            return entityManagerFactory;
        }
    }


}
