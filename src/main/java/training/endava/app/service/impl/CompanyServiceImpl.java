package training.endava.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Company;
import training.endava.app.exception.ResourceNotFoundException;
import training.endava.app.repository.CompanyRepository;
import training.endava.app.service.CompanyService;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company with id " + id + " does not exist"));
    }

    @Override
    public void save(Company c) {
        companyRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public void update(Long id, Company c) {
        companyRepository.update(id, c);
    }
}
