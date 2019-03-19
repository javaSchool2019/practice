package training.endava.app.Hibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.NeutralPerson;
import training.endava.app.Hibernate.serviceHibernate.NeutralPersonService;
import training.endava.app.exception.ParentException;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;
import training.endava.app.logging.LoggerExample;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/NeutralPerson")
public class NeutralPersonController {

    private Logger LOGGER = LoggerExample.returnLogger();
    @Autowired
    private NeutralPersonService persService;

    @GetMapping(value = "/allNeutralPerson")
    public List<NeutralPerson> allUsers() {
        try {
            return this.persService.getAllNeutralPersonFromDb();
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new ArrayList<NeutralPerson>();

        }

    }

    @GetMapping(value = "/id={ID}")
    public NeutralPerson getU(@PathVariable(value = "ID") Integer intId) {
        try {
            return this.persService.getNeutralPersonById(intId);
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new NeutralPerson();

        }

    }

    @PostMapping()
    public ResponseEntity addPersonToDataBase(@RequestBody NeutralPerson neutralPerson) {
        try {
            persService.addPersonToDataBase(neutralPerson);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(PersonAlreadyExistsException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t add it again");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity deletePerson(@PathVariable(value = "ID") Integer a) {
        try {
            return this.persService.delete(a);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t delete");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }

    }

    @PutMapping()
    public ResponseEntity updatePerson(@RequestBody NeutralPerson neutralPerson) {
        try {
            return this.persService.updatePerson(neutralPerson);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t update");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }



}
