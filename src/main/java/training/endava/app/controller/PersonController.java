package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.log;
import training.endava.app.myException;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private Logger LOGGER = log.returnLogger();
    @Autowired
    private PersonServiceImpl pServ;

    public PersonController() {
    }

    @GetMapping(value="/all")
        public List<Person> allUsers(){

            //return this.pServ.getAllPersons();
            return null;
        }

    @GetMapping(value="/id={ID}")
    public Optional<Person> getUser(@PathVariable (value = "ID") Integer intId){
        try {
            //return this.pServ.getPersonById(intId);
            return Optional.empty();
        }
        catch (RuntimeException e){
            LOGGER.severe("Error getPersonById method ");
            LOGGER.warning("Id invalid");
            return Optional.empty();
        }
    }

    @PostMapping()
    public ResponseEntity addPerson(@RequestBody Person person){
        System.out.println(person);
        //this.pServ.addPerson(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updatePerson (@RequestBody Person person){
        LOGGER.info("Id is updated");
        //return this.pServ.updatePerson(person);
        return null;
    }

    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity deletePerson (@PathVariable (value="ID") Integer a){
        LOGGER.info("Id is deleted");
        return null;
        //return this.pServ.delete(a);

    }
}
