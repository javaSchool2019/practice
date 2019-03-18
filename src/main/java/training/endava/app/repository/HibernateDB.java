package training.endava.app.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
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
        EntityManager entityManager =  HibernateConnection.buildEntityManager();
//        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Select p from PageEntry p", PageEntry.class);
//        Query query = entityManager.createNativeQuery("Select p from person p", PageEntry.class);
        List<PageEntry> persons = query.getResultList();
//        entityManager.getTransaction().commit();
        return persons;
    }

    public Optional<Person> getById(Integer id) {
        Person person = null;
        try {
            Statement stmt = null;
//            stmt = dbConnection.createStatement();
            String sql = "Select * from persons where person_id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                person = new Person(
                        rs.getInt("person_id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("birthplace"),
                        rs.getInt("address_id"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Optional<Person> op = Optional.ofNullable(person);
            return op;
        }
    }

    public void add(PersonInfo personInfo) {
        EntityManager entityManager =  HibernateConnection.buildEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(personInfo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Person person, Integer i) {
//        LOGGER.info("Update from DB");
//        String SQL = "UPDATE persons set name = ? ,birthday = ? ,birthplace = ? ,address_id = ? where person_id = ?";
//        System.out.println(person.getBirthday().getClass());
//        try (
//                PreparedStatement statement = dbConnection.prepareStatement(SQL)) {
//            statement.setInt(5, person.getPerson_id());
//            statement.setString(1, person.getName());
//            statement.setDate(2, person.getBirthday());
//            statement.setString(3, person.getBirthplace());
//            statement.setInt(4, person.getAddress_id());
//
//            statement.executeUpdate();
//        } catch (
//                SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    public void delete(Integer personId) {
//        LOGGER.info("Delete from DB");
//        String SQL = "DELETE FROM persons WHERE person_id = ?";
//        try (
//                PreparedStatement statement = dbConnection.prepareStatement(SQL)) {
//            statement.setInt(1, personId);
//
//            statement.executeUpdate();
//        } catch (
//                SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}
