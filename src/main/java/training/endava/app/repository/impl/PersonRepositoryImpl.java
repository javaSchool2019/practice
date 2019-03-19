package training.endava.app.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonDeleteException;
import training.endava.app.exception.PersonNotFoundException;
import training.endava.app.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> findAll() {
        return em.createNativeQuery("SELECT * FROM YELLOW_PAGES WHERE ENTRY_TYPE = 'P'", Person.class)
                .getResultList();
    }

    @Override
    public Optional<Person> findById(Long id) {
        Person person = em.createQuery("SELECT p FROM Person p WHERE p.id = :id ", Person.class)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.of(person);
    }

    @Override
    @Transactional
    public void save(Person p) {
        em.persist(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Person person = findById(id).orElseThrow(() -> new PersonDeleteException("Person with id " + id + " does not exist"));
        em.remove(person);
    }

    @Override
    @Transactional
    public void delete(Person p) {
        em.remove(p);
    }

    @Override
    @Transactional
    public void update(Long id, Person p) {
        Person person = findById(id).orElseThrow(() ->
                new PersonNotFoundException("Update failed. Person with id " + id + " was not found"));
        p.setId(person.getId());
        p.getAddress().setId(person.getAddress().getId());
        em.merge(p);
    }
}
