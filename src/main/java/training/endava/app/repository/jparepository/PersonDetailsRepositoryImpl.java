package training.endava.app.repository.jparepository;

import org.springframework.stereotype.Repository;
import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository

public class PersonDetailsRepositoryImpl implements PersonDetailsRepository{
    private EntityManager em;

    public void add(PersonDetails personDetails) {
        if(getById(personDetails.getId()) != null){
            throw new RuntimeException("Person already exists in DB");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.persist(personDetails);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(PersonDetails personDetails) {
        if(getById(personDetails.getId()) == null){
            throw new RuntimeException("Person doesn't exists in DB");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(personDetails) ? personDetails : em.merge(personDetails));
        em.getTransaction().commit();
        em.close();
    }

    public PersonDetails getById(Long id) {
        if(id == null){
            return null;
        }
        PersonDetails personDetails;
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        personDetails = em.find(PersonDetails.class, id);
        em.close();

        return personDetails;
    }

    public List<PersonDetails> getAll(){
        em = PostgresJPA.getInstance();
        TypedQuery<PersonDetails> query = em.createNamedQuery("PhoneDetails.findAll", PersonDetails.class);
        List<PersonDetails> personDetails = new ArrayList<>(query.getResultList());
        em.close();

        return personDetails;
    }

    public void update (PersonDetails personDetails){
        if (getById(personDetails.getId()) == null){
            throw new RuntimeException("PersonDetails doesn't exists in DB");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.merge(personDetails);
        em.getTransaction().commit();
        em.close();
    }
}
