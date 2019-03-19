package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.domain.PersonDTO;
import training.endava.app.domain.PersonMapper;
import training.endava.app.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/person", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll(){
        List<Person> persons = personRepository.getAll();
        List<PersonDTO> personDTOS = persons.stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO).collect(Collectors.toList());
        return ResponseEntity.ok(personDTOS);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> add(@RequestBody PersonDTO personDTO){
        Person person = PersonMapper.INSTANCE.personDTOToPerson(personDTO);
        personRepository.addPerson(person);
        return new ResponseEntity<>(personDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        Person person = PersonMapper.INSTANCE.personDTOToPerson(personDTO);
        personRepository.updatePerson(id, person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        personRepository.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
