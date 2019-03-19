package training.endava.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Company;
import training.endava.app.domain.Person;
import training.endava.app.payload.CompanyDto;
import training.endava.app.payload.PersonDto;
import training.endava.app.service.CompanyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {

    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@Valid @RequestBody CompanyDto personDTO) {
        companyService.save(personDTO.toCompany());
        return new ResponseEntity<>("Company added successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@Valid @RequestBody CompanyDto personDTO, @PathVariable Long id) {
        companyService.update(id, personDTO.toCompany());
        return new ResponseEntity<>("Company updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        companyService.delete(id);
        return new ResponseEntity<>("Person deleted successfully!", HttpStatus.OK);
    }
}
