package training.endava.app.repository.jparepository;

import org.springframework.stereotype.Repository;
import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.entity.PersonDetails;
import training.endava.app.domain.entity.PhoneNumber;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository

public class PersonDetailsRepositoryImpl implements PersonDetailsRepository{
    private EntityManager em;

    public void add(PersonDetails personDetails) {
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.persist(personDetails);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(PersonDetails personDetails) {
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(personDetails) ? personDetails : em.merge(personDetails));
        em.getTransaction().commit();
        em.close();
    }

    public PersonDetails getById(Long id) {
        PersonDetails personDetails;
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        personDetails = em.find(PersonDetails.class, id);
        if (personDetails == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + id);
        }
        em.close();

        return personDetails;
    }

    public List<PersonDetails> getAll(){
        em = PostgresJPA.getInstance();
        TypedQuery<PersonDetails> query = em.createNamedQuery("PhoneNumber.findAll", PersonDetails.class);
        List<PersonDetails> personDetails = new ArrayList<>(query.getResultList());
        em.close();

        return personDetails;
    }

    public void update (PersonDetails personDetails){
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.merge(personDetails);
        em.getTransaction().commit();
        em.close();
    }
}
