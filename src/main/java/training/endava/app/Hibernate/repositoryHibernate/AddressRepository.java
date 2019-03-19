package training.endava.app.Hibernate.repositoryHibernate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import training.endava.app.Hibernate.EntManagerFact;
import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.exception.PersonDoesntExistException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AddressRepository {

    private EntityManagerFactory emFact = EntManagerFact.getInstance();

    public List<Address> getAllAddressFromDb() {
        EntityManager em = emFact.createEntityManager();

        Query result = em.createNativeQuery("select a from address a", Address.class);

        List<Address> addressList = result.getResultList();

        em.close();

        return addressList;


    }
    public Address getAddressById(Integer intId) {

        EntityManager em = emFact.createEntityManager();

        em.getTransaction().begin();

        Address address = em.find(Address.class, intId);

        em.close();

        return address;

    }
    public void addAddressToDataBase(Address address) {


        EntityManager em = emFact.createEntityManager();

        em.getTransaction().begin();

        em.persist(address);

        em.getTransaction().commit();

        em.close();

    }
    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        try {

            EntityManager em = emFact.createEntityManager();
            Address address = getAddressById(a);
            em.getTransaction().begin();
            em.remove(address);
            em.getTransaction().commit();
            em.close();
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {

            e.fillInStackTrace();
            return ResponseEntity.ok(HttpStatus.CONFLICT);


        }

    }
    public ResponseEntity updateAddress(Address address) throws PersonDoesntExistException {
        try {

            EntityManager em = emFact.createEntityManager();

            em.getTransaction().begin();

            em.merge(address);

            em.getTransaction().commit();

            em.close();
            return ResponseEntity.ok(HttpStatus.OK);


        } catch (Exception e) {

            e.fillInStackTrace();
            return ResponseEntity.ok(HttpStatus.OK);


        }

    }

}
