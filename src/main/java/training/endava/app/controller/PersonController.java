package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.filter.PersonDTO;
import training.endava.app.mapper.PersonMapper;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.impl.PersonServiceImpl;

import java.util.List;

@RestController
//@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/person")
    public List<Person> getAllPersons()
    {
        return this.personService.returnAll();
    }

    @GetMapping("/person/{id}")
    public Person retrievePerson(@PathVariable(value = "id") int id) {
        return this.personService.getById(id);
    }

    @RequestMapping(value = "/person/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person ResponseEntityJson(@PathVariable(value = "id") int id) {
        return this.personService.getById(id);
    }

    @GetMapping("/dto/{id}")
    public PersonDTO DTOPerson(@PathVariable(value = "id") int id) {
        return PersonMapper.INSTANCE.personToPersonDTO( this.personService.getById(id));
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable(value = "id") int id) {
        this.personService.deleteById(id);
    }

    @PutMapping(path = "/person/")
    public void updatePerson(@RequestBody Person person){
        this.personService.updatePerson(person);
    }


    @PostMapping(path = "/person")
    public void addMember(@RequestBody Person person) {
        this.personService.createNewPerson(person);
    }



}
