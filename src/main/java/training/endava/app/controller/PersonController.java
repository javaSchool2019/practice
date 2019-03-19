package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.entity.Person;
import training.endava.app.payload.mapper.PersonMapper;
import training.endava.app.repository.jparepository.PersonRepository;
import training.endava.app.repository.jparepository.PersonRepositoryImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(personRepository.getById(id), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<?> getAll() {


        return new ResponseEntity<>(personRepository.getCriteria(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        Person person = personRepository.getById(id);
        personRepository.delete(person);
        return new ResponseEntity<>("Entity was removed", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        personRepository.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable long id, @Valid @RequestBody Person person) {
        if (personRepository.getById(id) == null) {
            return new ResponseEntity<>("unmodified", HttpStatus.CONFLICT);
        }
        person.setId(id);
        personRepository.update(person);
        return new ResponseEntity<>(PersonMapper.INSTANCE.personToPersonDTO(person), HttpStatus.OK);


    }


}
