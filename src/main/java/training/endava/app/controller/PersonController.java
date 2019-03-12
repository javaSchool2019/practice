package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.mapStruct.PersonDTO;
import training.endava.app.mapStruct.PersonMapper;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.PersonServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonServiceImpl personService){
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll(){
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> add(@RequestBody Person person){
        personService.addPerson(person);
        return new ResponseEntity<>(PersonMapper.INSTANCE.personToPersonDTO(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Person person){
        personService.updatePerson(id, person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        personService.deletePerson(id);
        return ResponseEntity.ok(null);
    }
}