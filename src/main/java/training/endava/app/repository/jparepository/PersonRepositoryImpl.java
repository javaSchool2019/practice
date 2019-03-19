package training.endava.app.repository.jparepository;

import org.springframework.stereotype.Repository;
import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.entity.Person;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonExceptionNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository

public class PersonRepositoryImpl implements PersonRepository {
    private EntityManager em;

    public void add(Person person) {
        if (getById(person.getId()) != null) {
            throw new PersonAlreadyExistsException("Person already exists in Db");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Person person) {
        if (getById(person.getId()) == null) {
            throw new PersonExceptionNotFoundException("Person not found in Db");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();
        em.close();
    }

    public Person getById(Long id) {
        Person person;
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        person = em.find(Person.class, id);
        em.close();

        if (person == null) {
            throw new EntityNotFoundException("Can't find Person for ID "
                    + id);
        }

        return person;
    }

    public List<Person> getAll() {
        em = PostgresJPA.getInstance();
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> personList = new ArrayList<>(query.getResultList());
        em.close();

        return personList;
    }

    public void update(Person person) {
        if (getById(person.getId()) == null) {
            throw new PersonExceptionNotFoundException("Person not found in Db");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }
}
