package training.endava.app.repository.jparepository;

import org.springframework.stereotype.Repository;
import training.endava.app.database.Postgres;
import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.entity.PhoneNumber;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PhoneNumberRepositoryImp implements PhoneNumberRepository{
    private EntityManager em;

    public void add(PhoneNumber phoneNumber) {
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.persist(phoneNumber);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(PhoneNumber phoneNumber) {
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(phoneNumber) ? phoneNumber : em.merge(phoneNumber));
        em.getTransaction().commit();
        em.close();
    }

    public PhoneNumber getById(Long id) {
        PhoneNumber phoneNumber;
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        phoneNumber = em.find(PhoneNumber.class, id);
        if (phoneNumber == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + id);
        }
        em.close();

        return phoneNumber;
    }

    public List<PhoneNumber> getAll(){
        em = PostgresJPA.getInstance();
        TypedQuery<PhoneNumber> query = em.createNamedQuery("PhoneNumber.findAll", PhoneNumber.class);
        List<PhoneNumber> phoneNumbers = new ArrayList<>(query.getResultList());
        em.close();

        return phoneNumbers;
    }

    public void update (PhoneNumber phoneNumber){
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.merge(phoneNumber);
        em.getTransaction().commit();
        em.close();
    }

}
