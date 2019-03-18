package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.domain.PersonDTO;
import training.endava.app.helpers.EntityManagerFactoryHelper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepository {

    public PersonRepository() {

    }

    public List<Person> getAll() {
        EntityManager entityManager = EntityManagerFactoryHelper.getFactory().createEntityManager();
        TypedQuery<Person> query = entityManager.createQuery("Select p from Person p", Person.class);
        List<Person> persons = query.getResultList();
        entityManager.close();
        return persons;
    }

    public void addPerson(Person person) {
        EntityManager entityManager = EntityManagerFactoryHelper.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updatePerson(Person person) {
        EntityManager entityManager = EntityManagerFactoryHelper.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Person personInDb = entityManager.find(Person.class, person);
        personInDb.setLastName(person.getLastName());
        personInDb.setFirstName(person.getFirstName());
        personInDb.setAddress(person.getAddress());
        personInDb.setPhoneNumber(person.getPhoneNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deletePerson(long id) {
//        try (Connection conn = PostgreDB.getConnection()){
//            String query = "DELETE FROM persons WHERE id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//        }
//        catch (SQLException exception){
//            LOGGER.warning("Error connecting to db" + exception);
//        }
    }
}
