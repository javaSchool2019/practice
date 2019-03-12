package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.DTOMapper.PersonDTO;
import training.endava.app.DTOMapper.PersonMapper;
import training.endava.app.domain.Person;
import training.endava.app.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService serv;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(serv.getAll());
    }

    @GetMapping(value = "/getById={ID}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getById(@PathVariable(value = "ID") Integer id) {
        return ResponseEntity.ok(PersonMapper.INSTANCE.persontoPersonDTO(serv.getById(id)));
    }

    @PostMapping(value = "/post")
    ResponseEntity postPerson(@RequestBody Person person) {
        if (person.getId() == null || person.getName() == null) {
            throw new IllegalArgumentException("At least one parameter is invalid or not supplied");
        }
        serv.addNewPersonToDB(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/put")
    ResponseEntity putPerson(@RequestBody Person person) {
        serv.update(person);
        return ResponseEntity.ok(PersonMapper.INSTANCE.persontoPersonDTO(serv.getById(person.getId())));
    }

    @PutMapping(value = "/test" , consumes = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity test(@RequestBody PersonDTO person) {
        System.out.println(person);
        Person pers = PersonMapper.INSTANCE.personDTOtoPerson(person);
        return ResponseEntity.ok(pers);
    }

    @DeleteMapping("/delete={ID}")
    ResponseEntity deletePerson(@PathVariable(value = "ID") Integer id) {
        serv.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
