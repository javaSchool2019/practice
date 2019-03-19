package training.endava.app.Hibernate.repositoryHibernate;

import training.endava.app.Hibernate.domainHibernate.PhoneNumber;
import training.endava.app.Hibernate.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PhoneNumberRepository  {
    private EntityManagerFactory entityManagerFactory = entityManager.getinstance();

    public PhoneNumber add (PhoneNumber entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        PhoneNumber phoneNumber = entityManager.find(PhoneNumber.class, entity.getId());
        entityManager.close();
        return phoneNumber;
    }

    public PhoneNumber getById (int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        PhoneNumber phoneNumber = entityManager.find(PhoneNumber.class,id);
        entityManager.close();
        return phoneNumber;
    }

    public List<PhoneNumber> all(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<PhoneNumber> result = entityManager.createQuery("select p from PhoneNumber p",PhoneNumber.class);
        List<PhoneNumber> employeeList = result.getResultList();
        return employeeList;
    }

    public boolean update (PhoneNumber entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    public boolean deleteById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PhoneNumber phoneNumber = getById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(phoneNumber);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
}
