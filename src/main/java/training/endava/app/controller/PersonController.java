package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import training.endava.app.mapper.PersonMapper;
import training.endava.app.payload.PersonDto;
import training.endava.app.service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersons() {
        return new ResponseEntity<>(personService.findAll().stream().map(PersonMapper.INSTANCE::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Long id) {
        return new ResponseEntity<>(PersonMapper.INSTANCE.toDto(personService.findById(id)), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<String> addPerson(@Valid @RequestBody PersonDto personDTO) {
        personService.add(PersonMapper.INSTANCE.toPerson(personDTO));
        return new ResponseEntity<>("Person added successfully!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>("Person deleted successfully!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody PersonDto personDTO, @PathVariable Long id) {
        personService.update(id, PersonMapper.INSTANCE.toPerson(personDTO));
        return new ResponseEntity<>("Person updated successfully!", HttpStatus.OK);
    }
}
