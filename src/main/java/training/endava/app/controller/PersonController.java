package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.exception.ParentException;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;
import training.endava.app.logging.LoggerExample;
import training.endava.app.mapStruct.PersonDTO;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import training.endava.app.logging.LoggerExample;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private Logger LOGGER = LoggerExample.returnLogger();

//CRUD for DB
    @Autowired
    private PersonServiceImpl pServ;

    @GetMapping(value = "/all")
    public List<Person> allUsers() {
        LOGGER.log(Level.INFO, "Warning :");
        try {
            return this.pServ.getAllPersonFromDB();
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new ArrayList<Person>();

        }

    }
    @PostMapping()
    public ResponseEntity addPersonToDataBase(@RequestBody Person person) {
        try {
            System.out.println("persContr"+person);
            pServ.addPersonToDataBase(person);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(PersonAlreadyExistsException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t add it again");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }








    //Crud
   /* @GetMapping(value = "/all")
    public List<PersonDTO> allUsers() {
        LOGGER.log(Level.INFO, "Warning :");
        try {
            return this.pServ.getAllPersons();
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new ArrayList<PersonDTO>();

        }

    }
*/
  /*  @GetMapping(value = "/id={ID}")
    public Optional<Person> getUser(@PathVariable(value = "ID") Integer intId) {

        try {
            return this.pServ.getPersonById(intId);
        } catch (PersonDoesntExistException e) {
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist, can t Get it");
         return Optional.empty();
        }

    }
    */

/*

    @PostMapping()
    public ResponseEntity addPerson(@RequestBody Person person) {
        try {
            System.out.println(person);
            this.pServ.addPerson(person);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(PersonAlreadyExistsException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t add it again");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }
    */
/*
    @PutMapping()
    public ResponseEntity updatePerson(@RequestBody Person person) {
        try {
            return this.pServ.updatePerson(person);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t update");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity deletePerson(@PathVariable(value = "ID") Integer a) {
        try {
            return this.pServ.delete(a);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t delete");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }

    }
     */
}