package training.endava.app.repository.jparepository;

import org.springframework.stereotype.Repository;
import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.entity.Person;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonExceptionNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        if(id == null){
            return null;
        }
        Person person;
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public List<Person> getAll() {
        em = PostgresJPA.getInstance();
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> personList = new ArrayList<>(query.getResultList());
        em.close();

        return personList;
    }

    @Override
    public List<Person> getCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> c = q.from(Person.class);
        q.select(c).where(cb.equal(c.get("name"), "TestNameUpdate2"));
        return em.createQuery(q).getResultList();
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
