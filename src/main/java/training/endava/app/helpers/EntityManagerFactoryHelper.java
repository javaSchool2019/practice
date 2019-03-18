package training.endava.app.helpers;

import training.endava.app.logger.YellowPagesLogger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static training.endava.app.logger.YellowPagesLogger.LOGGER;

public class EntityManagerFactoryHelper {

    private static EntityManagerFactory factory = null;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("entityManager");
        } catch(ExceptionInInitializerError e) {
            LOGGER.severe("Error Entity manager: " + e.getMessage());
        }
    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }
}
