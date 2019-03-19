package training.endava.app.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import training.endava.app.domain.Person;
import training.endava.app.domain.hibernateObjects.PageEntry;
import training.endava.app.domain.hibernateObjects.PersonInfo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Component
public class HibernateDB {

    private final LogManager logManager = LogManager.getLogManager();
    static Session sessionObj;

    @Transactional
    public List<PageEntry> getList() {
        EntityManager entityManager = HibernateConnection.buildEntityManager();

        Query query = entityManager.createQuery("Select p from PageEntry p", PageEntry.class);

        List<PageEntry> persons = query.getResultList();

        return persons;
    }

    public Optional<PersonInfo> getById(Integer id) {
        EntityManager entityManager = HibernateConnection.buildEntityManager();

        Query query = entityManager.createQuery("Select p from PageEntry p where id=" + id, PageEntry.class);

        Optional<PersonInfo> optionalPersonInfo = Optional.ofNullable((PersonInfo) query.getSingleResult());

        return optionalPersonInfo;
    }

    public void add(PersonInfo personInfo) {
        EntityManager entityManager = HibernateConnection.buildEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(personInfo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(PersonInfo person, Integer id) {
        EntityManager entityManager = HibernateConnection.buildEntityManager();
        PersonInfo personFromDB = entityManager.find(PersonInfo.class, id);
        if (personFromDB != null) {
            entityManager.getTransaction().begin();
            personFromDB.setName(person.getName());
            personFromDB.setBirthday(person.getBirthday());
            personFromDB.setBirthplace(person.getBirthplace());
            personFromDB.setAddress_id(person.getAddress_id());
            entityManager.getTransaction().commit();
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = HibernateConnection.buildEntityManager();
        PersonInfo personFromDB = entityManager.find(PersonInfo.class, id);
        if (personFromDB != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(personFromDB);
            entityManager.getTransaction().commit();
        }
    }
}
