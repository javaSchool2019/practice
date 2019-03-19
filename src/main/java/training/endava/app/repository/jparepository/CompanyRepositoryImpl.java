package training.endava.app.repository.jparepository;

import org.springframework.stereotype.Repository;
import training.endava.app.database.PostgresJPA;
import training.endava.app.domain.entity.Company;
import training.endava.app.domain.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    private EntityManager em;

    public void add(Company company) {
        if(getById(company.getId()) != null){
            throw new RuntimeException("Company already exists");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Company company) {
        if(getById(company.getId()) == null){
            throw new RuntimeException("Company does'nt exists in DB");
        }
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(company) ? company : em.merge(company));
        em.getTransaction().commit();
        em.close();
    }

    public Company getById(Long id) {
        if(id == null){
            return null;
        }
        Company company;
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        company = em.find(Company.class, id);
        em.close();

        return company;
    }

    public List<Company> getAll(){
        em = PostgresJPA.getInstance();
        TypedQuery<Company> query = em.createNamedQuery("Company.findAll", Company.class);
        List<Company> companies = new ArrayList<>(query.getResultList());
        em.close();

        return companies;
    }

    public void update (Company company){
        em = PostgresJPA.getInstance();
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
        em.close();
    }
}
