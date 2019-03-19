package training.endava.app.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.payload.PersonDto;
import training.endava.app.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@Valid @RequestBody PersonDto personDTO) {
        personService.save(personDTO.toPerson());
        return new ResponseEntity<>("Person added successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody PersonDto personDTO, @PathVariable Long id) {
        personService.update(id, personDTO.toPerson());
        return new ResponseEntity<>("Person updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>("Person deleted successfully!", HttpStatus.OK);
    }
}
