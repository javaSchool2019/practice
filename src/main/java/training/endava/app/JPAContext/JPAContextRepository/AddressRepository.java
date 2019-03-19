package training.endava.app.JPAContext.JPAContextRepository;

import org.springframework.stereotype.Repository;
import training.endava.app.JPAContext.JPAdomain.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AddressRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    //create
    @Transactional
    public void insertWithQuery(Address address)
    {
            entityManager.createNativeQuery("INSERT INTO ADDRESSES (city, country,street) VALUES (?,?,?)")
                    .setParameter(1, address.getCity())
                    .setParameter(2, address.getCountry())
                    .setParameter(3, address.getStreet())

                    .executeUpdate();
    }

    //read all
    public List<Address> findAll()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> cq = cb.createQuery(Address.class);
        Root<Address> rootEntry = cq.from(Address.class);
        CriteriaQuery<Address> all = cq.select(rootEntry);
        TypedQuery<Address> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    //read all
    public List<Address> findAll2() {
        return entityManager.createQuery("SELECT * FROM ADDRESSES").getResultList();
    }

    //read by id
    public Address findById(Integer id)
    {
        return entityManager.find(Address.class, id);
    }

    //update
    @Transactional
    public Address updateAddress(Address address)
    {
        return entityManager.merge(address);
    }

    //delete
    @Transactional
    public void deleteAddress(Integer id)
    {
        entityManager.createNativeQuery("DELETE FROM ADDRESSES D WHERE ID = " + id).executeUpdate();
    }

}
