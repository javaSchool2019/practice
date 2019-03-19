package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.helpers.EntityManagerFactoryHelper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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

    @Transactional
    public void addPerson(Person person) {
        EntityManager entityManager = EntityManagerFactoryHelper.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updatePerson(Long id, Person person) {
        EntityManager entityManager = EntityManagerFactoryHelper.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Person personDb = entityManager.find(Person.class, id);
        if(personDb != null){
            personDb.setFirstName(person.getFirstName());
            personDb.setLastName(person.getLastName());
            personDb.setAddress(person.getAddress());
            personDb.setPhoneNumbers(person.getPhoneNumbers());
            entityManager.flush();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deletePerson(Long id) {
        EntityManager entityManager = EntityManagerFactoryHelper.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        if(person != null)
            entityManager.remove(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
