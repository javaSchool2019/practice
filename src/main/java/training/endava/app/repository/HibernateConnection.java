package training.endava.app.repository;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;

public class HibernateConnection {
    public static EntityManager  buildEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
