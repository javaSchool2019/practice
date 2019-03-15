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
import training.endava.app.logging.LOGGER;
//import training.endava.app.mappers.PersonMapper;
//import training.endava.app.repository.PersonRepository;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private Logger logger = LOGGER.getInstanceWithFileHandler(this.getClass().getName());

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<?> getPersonById(@PathVariable(value="ID") Integer id){
        logger.info("[HTTP VERBS] : GET method call.");
        Person person = this.personService.getPersonById(id);
        if(person == null)
            throw new PersonNotFoundException("Person you search for does not exists.");
        else
            return new ResponseEntity<Person>(person,HttpStatus.OK);
    }

    @GetMapping()
    public List<?> getAllPersons(){
        logger.info("[HTTP VERBS] : GET method call.");
        return this.personService.getAllPersons();
    }

    @PostMapping()
    public ResponseEntity<?> addPerson(@RequestBody @Valid Person person){
        logger.info("[HTTP VERBS] : POST method call.");
        return new ResponseEntity(person,this.personService.addPerson(person));
    }

    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity deletePersonById(@PathVariable(value="ID") Integer id){
        logger.info("[HTTP VERBS] : DELETE method call.");
        return new ResponseEntity(this.personService.deletePersonById(id));
    }

    @PatchMapping()
    public ResponseEntity updatePerson(@RequestBody Person person){
        logger.info("[HTTP VERBS] : PATCH method call.");
        return new ResponseEntity(this.personService.updatePerson(person));
    }


}
