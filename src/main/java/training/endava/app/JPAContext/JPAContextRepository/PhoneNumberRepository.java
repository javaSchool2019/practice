package training.endava.app.JPAContext.JPAContextRepository;

import org.springframework.stereotype.Repository;
import training.endava.app.JPAContext.JPAdomain.PhoneNumber;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PhoneNumberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //create
    @Transactional
    public void insertWithQuery(PhoneNumber phoneNumber)
    {
        entityManager.createNativeQuery("INSERT INTO PHONE_NUMBERS (city, country,street) VALUES (?,?,?)")
                .setParameter(1, phoneNumber.getNumber())
                .setParameter(2, phoneNumber.getServiceProvider())
                .setParameter(3, phoneNumber.getWorkingEntityId())

                .executeUpdate();
    }

    //read all
    public List<PhoneNumber> findAll() {
        return entityManager.createQuery("SELECT * FROM PHONE_NUMBERS").getResultList();
    }

    //read by id
    public PhoneNumber findById(Integer id)
    {
        return entityManager.find(PhoneNumber.class, id);
    }

    //update
    @Transactional
    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber)
    {
        return entityManager.merge(phoneNumber);
    }

    //delete
    @Transactional
    public void deletePhoneNumber(Integer id)
    {
        entityManager.createNativeQuery("DELETE FROM PHONE_NUMBERS PN WHERE ID =: " + id).executeUpdate();
    }
}
