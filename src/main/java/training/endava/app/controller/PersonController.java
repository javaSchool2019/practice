package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.domain.PersonDTO;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.PersonServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/person", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok(personRepository.getAll());
    }

    @PostMapping
    public ResponseEntity<Person> add(@RequestBody Person person){
        personRepository.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person){
        personRepository.updatePerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable long id){
//        personService.deletePerson(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
