package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import school.domain.Person;
import school.service.impl.PersonServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    public PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, Person> retrieveAllPersons() {
        return personService.getAllPersons();
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person changePersonDetails(@PathVariable Integer id, @RequestBody Person person) {
        return personService.changePersonDetails(id, person);
    }
}
