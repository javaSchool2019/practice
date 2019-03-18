package training.endava.app.repository.jparepository;

import training.endava.app.domain.entity.Company;
import training.endava.app.domain.entity.PersonDetails;

import java.util.List;

public interface CompanyRepository {
    void add(Company company);
    void delete(Company company);
    Company getById(Long id);
    List<Company> getAll();
    void update (Company company);
}
