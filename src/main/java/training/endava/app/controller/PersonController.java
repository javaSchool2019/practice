package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonServiceImpl pServ;

    @GetMapping(value="/all")
    public List<Person> allUsers(){
        return this.pServ.getAllPersons();
    }

    @GetMapping(value="/id={ID}")
    public Optional<Person> getUser(@PathVariable (value = "ID") Integer intId){
        return this.pServ.getPersonById(intId);
    }

    @PostMapping()
    public ResponseEntity addPerson(@RequestBody Person person){
        System.out.println(person);
        this.pServ.addPerson(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updatePerson (@RequestBody Person person){
        return this.pServ.updatePerson(person);
    }

    @DeleteMapping(value = "/id = {ID}")
    public ResponseEntity deletePerson (@PathVariable (value="ID") Integer a){
        return this.pServ.delete(a);

    }
}
