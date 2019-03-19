package training.endava.app.Hibernate.repositoryHibernate;

import training.endava.app.Hibernate.domainHibernate.Company;
import training.endava.app.Hibernate.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompanyRepository {
    private EntityManagerFactory entityManagerFactory = entityManager.getinstance();

    public Company add(Company entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        Company company = entityManager.find(Company.class,entity.getId());
        entityManager.close();
        return company;
    }

    public Company getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class,id);
        entityManager.close();
        return company;
    }

    public List<Company> all (){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Company> result = entityManager.createQuery("select c from Company c",Company.class);
        List<Company> companyList = result.getResultList();
        return companyList;
    }

    public boolean update(Company entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    public boolean deleteById (int id){

         EntityManager entityManager = entityManagerFactory.createEntityManager();
         Company company = getById(id);
         entityManager.getTransaction().begin();
         entityManager.remove(company);
         entityManager.getTransaction().commit();
         entityManager.close();
         return true;
    }
}
