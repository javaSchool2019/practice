package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.exceptions.PersonNotFoundException;
import training.endava.app.filters.PersonDTO;
import training.endava.app.mappers.PersonMapper;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping(value = "/id={ID}", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPersonById(@PathVariable(value="ID") Integer id){
        Person person = this.personService.getPersonById(id);
        if(person == null)
            throw new PersonNotFoundException("Person you search for does not exists.");
        else
            return new ResponseEntity<PersonDTO>(PersonMapper.INSTANCE.personToPersonDTO(person),HttpStatus.OK);
    }

    @GetMapping()
    public List<?> getAllPersons(){
        return this.personService.getAllPersons();
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> addPerson(@RequestBody @Valid Person person){
        return new ResponseEntity(PersonMapper.INSTANCE.personToPersonDTO(person),this.personService.addPerson(person));
    }

    @PutMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> replacePerson(@RequestBody @Valid Person person){
        return new ResponseEntity(PersonMapper.INSTANCE.personToPersonDTO(person), this.personService.replacePerson(person));
    }

    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity deletePersonById(@PathVariable(value="ID") Integer id){
        return new ResponseEntity(this.personService.deletePersonById(id));
    }

    @PatchMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity updatePerson(@RequestBody Person person){
        return new ResponseEntity(this.personService.updatePerson(person));
    }


}
