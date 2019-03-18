package training.endava.app.repository.jparepository;

import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.Person;
import training.endava.app.domain.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl {
    private EntityManager em;

    public void add(Person person) {
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Person person) {
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
        if (person == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + id);
        }
        em.close();

        return person;
    }

    public List<Person> getAll(){
        em = PostgresJPA.getInstance();
        TypedQuery<Person> query = em.createNamedQuery("PhoneNumber.findAll", Person.class);
        List<Person> personList = new ArrayList<>(query.getResultList());
        em.close();

        return personList;
    }

    public void update (Person person){
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }
}
