package training.endava.app.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EM {

    private static EntityManagerFactory entityManagerFactory = null;

	private EM(){
            entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");


    }
    public static EntityManagerFactory getInstance(){
        if(entityManagerFactory == null){
            new EM();
            return getInstance();
        }
        else{
            return entityManagerFactory;
        }
    }
}
