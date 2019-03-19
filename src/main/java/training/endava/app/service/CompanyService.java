package training.endava.app.service;

import training.endava.app.domain.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findById(Long id);
    void save(Company p);
    void delete(Long id);
    void update(Long id, Company p);
}
