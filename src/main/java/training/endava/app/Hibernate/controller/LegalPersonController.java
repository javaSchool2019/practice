package training.endava.app.Hibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.LegalPerson;
import training.endava.app.Hibernate.serviceHibernate.LegalPersonService;
import training.endava.app.exception.ParentException;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;
import training.endava.app.logging.LoggerExample;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/LegalPerson")
public class LegalPersonController {

    private Logger LOGGER = LoggerExample.returnLogger();

    @Autowired
    private LegalPersonService adrServ;

    @GetMapping(value = "/allLegalPerson")
    public List<LegalPerson> allUsers() {
        try {
            return this.adrServ.getAllLegalPersonFromDb();
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new ArrayList<LegalPerson>();

        }

    }
    @GetMapping(value = "/id={ID}")
    public LegalPerson getU(@PathVariable(value = "ID") Integer intId) {
        try {
            return this.adrServ.getLegalPersonById(intId);
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new LegalPerson();

        }

    }
    @PostMapping()
    public ResponseEntity addPersonToDataBase(@RequestBody LegalPerson legalPerson) {
        try {
            adrServ.addPersonToDataBase(legalPerson);
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
            return this.adrServ.delete(a);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t delete");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }

    }

    @PutMapping()
    public ResponseEntity updatePerson(@RequestBody LegalPerson legalPerson) {
        try {
            return this.adrServ.updatePerson(legalPerson);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("person doesn t exist,Can t update");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }

}
