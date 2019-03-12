package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.payload.ApiResponse;
import training.endava.app.payload.PersonDTO;
import training.endava.app.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Person>>> findAllPersons() {
        return new ResponseEntity<>(new ApiResponse<>(personService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Person>> findPersonById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(personService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addPerson(@Valid @RequestBody PersonDTO personDTO) {
        personService.add(personDTO.toPerson());
        return new ResponseEntity<>(new ApiResponse<>("Person added successfully!"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>(new ApiResponse<>("Person deleted successfully!"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updatePerson(@Valid @RequestBody PersonDTO personDTO, @PathVariable Long id) {
        personService.update(id, personDTO);
        return new ResponseEntity<>(new ApiResponse<>("Person updated successfully!"), HttpStatus.OK);
    }

}
