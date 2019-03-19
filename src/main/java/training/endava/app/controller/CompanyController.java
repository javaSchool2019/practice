package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.entity.Company;
import training.endava.app.domain.entity.Person;
import training.endava.app.payload.mapper.CompanyMapper;
import training.endava.app.payload.mapper.PersonMapper;
import training.endava.app.repository.jparepository.CompanyRepository;
import training.endava.app.repository.jparepository.CompanyRepositoryImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepositoryImpl companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(companyRepository.getById(id), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(companyRepository.getAll(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        Company company = companyRepository.getById(id);
        companyRepository.delete(company);
        return new ResponseEntity<>("Entity was removed", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addPerson(@Valid @RequestBody Company company) {
        companyRepository.add(company);
        return new ResponseEntity<>(CompanyMapper.INSTANCE.companyToCompanyDTO(company), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable long id, @Valid @RequestBody Company company) {
        company.setId(id);
        companyRepository.update(company);
        return new ResponseEntity<>(CompanyMapper.INSTANCE.companyToCompanyDTO(company), HttpStatus.OK);


    }
}
