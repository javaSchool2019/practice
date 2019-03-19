package training.endava.app.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import training.endava.app.domain.Company;
import training.endava.app.exception.PersonDeleteException;
import training.endava.app.exception.PersonNotFoundException;
import training.endava.app.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
