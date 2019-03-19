package training.endava.app.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import training.endava.app.domain.Company;
import training.endava.app.exception.PersonDeleteException;
import training.endava.app.exception.PersonNotFoundException;
import training.endava.app.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Company> findAll() {
        return em.createQuery("SELECT c FROM Company c", Company.class)
                .getResultList();
    }

    @Override
    public Optional<Company> findById(Long id) {
        Company company = em.createQuery("SELECT c FROM Company c WHERE c.id = :id ", Company.class)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.of(company);
    }

    @Override
    @Transactional
    public void save(Company c) {
        em.persist(c);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Company company = findById(id).orElseThrow(() -> new PersonDeleteException("Company with id " + id + " does not exist"));
        em.remove(company);
    }

    @Override
    @Transactional
    public void update(Long id, Company c) {
        Company company = findById(id).orElseThrow(() ->
                new PersonNotFoundException("Update failed. Company with id " + id + " was not found"));
        c.setId(company.getId());
        c.getAddress().setId(company.getAddress().getId());
        em.merge(c);
    }

    @Override
    public List<Company> findByCompanyName(String companyName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> query = cb.createQuery(Company.class);
        Root<Company> company = query.from(Company.class);
        ParameterExpression<String> p = cb.parameter(String.class, "company_name");
        query.select(company).where(cb.like(company.get("companyName"), p));
        return em.createQuery(query).setParameter("company_name", companyName + "%").getResultList();
    }

    @Override
    public List<Company> findByDummyParametersJustToUseCriterion(Long id, String companyName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> query = cb.createQuery(Company.class);
        Root<Company> company = query.from(Company.class);
        ParameterExpression<Long> p1 = cb.parameter(Long.class, "id");
        ParameterExpression<String> p2 = cb.parameter(String.class, "company_name");

        List<Predicate> criteria = new ArrayList<>();
        criteria.add(cb.equal(company.get("companyName"), p2));
        criteria.add(cb.ge(company.get("id"), p1));

        query.select(company)
                .where(criteria.get(0))
                .where(criteria.get(1));
        return em.createQuery(query)
                .setParameter("company_name", companyName)
                .setParameter("id", id)
                .getResultList();
    }
}
