package training.endava.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Company;
import training.endava.app.payload.CompanyDto;
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
    public ResponseEntity<String> addCompany(@Valid @RequestBody CompanyDto companyDto) {
        companyService.save(companyDto.toCompany());
        return new ResponseEntity<>("Company added successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@Valid @RequestBody CompanyDto companyDto, @PathVariable Long id) {
        companyService.update(id, companyDto.toCompany());
        return new ResponseEntity<>("Company updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        companyService.delete(id);
        return new ResponseEntity<>("Company deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Company>> findCompanyByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(companyService.findByCompanyName(name), HttpStatus.OK);
    }
}
