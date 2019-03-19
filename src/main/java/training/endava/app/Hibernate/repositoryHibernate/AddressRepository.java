package training.endava.app.Hibernate.repositoryHibernate;

import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.Hibernate.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressRepository {
    private EntityManagerFactory entityManagerFactory = entityManager.getinstance();

    public Address add(Address entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        Address address = entityManager.find(Address.class,entity.getId());
        entityManager.close();
        return address;
    }

    public Address getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class,id);
        entityManager.close();
        return address;
    }

    public List<Address> all (){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Address> result = entityManager.createQuery("select a from Address a",Address.class);
        List<Address> addressList = result.getResultList();
        return addressList;
    }

    public boolean update(Address entity){
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch(Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    public boolean deleteById (int id){
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Address address = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(address);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch(Exception e){
            e.fillInStackTrace();
            return false;
        }
    }
}
