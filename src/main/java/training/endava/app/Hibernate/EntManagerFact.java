package training.endava.app.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntManagerFact {

    private static EntityManagerFactory entityManagerFactory = null;

    private EntManagerFact(){
        entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");


    }
    public static EntityManagerFactory getInstance(){
        if(entityManagerFactory == null){
            new EntManagerFact();
            return getInstance();
        }
        else{
            return entityManagerFactory;
        }
    }
}