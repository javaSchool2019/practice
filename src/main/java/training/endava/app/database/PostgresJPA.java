package training.endava.app.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;



public class PostgresJPA {

    public static EntityManager getInstance() {
        return Persistence.createEntityManagerFactory("entityManager").createEntityManager();
    }

}
