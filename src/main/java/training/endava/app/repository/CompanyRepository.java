package training.endava.app.repository;

import training.endava.app.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    List<Company> findAll();
    Optional<Company> findById(Long id);
    void save(Company p);
    void delete(Long id);
    void update(Long id, Company p);
}
