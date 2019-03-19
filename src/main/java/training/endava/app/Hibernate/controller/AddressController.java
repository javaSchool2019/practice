package training.endava.app.Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.Hibernate.serviceHibernate.AddressService;
import training.endava.app.exception.ParentException;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;
import training.endava.app.logging.LoggerExample;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/Address")
public class AddressController {

    private Logger LOGGER = LoggerExample.returnLogger();
    @Autowired
    protected AddressService adrServ;

    @GetMapping(value = "/allAddress")
    public List<Address> allAddress() {
        try {
            return this.adrServ.getAllAddressFromDb();
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new ArrayList<Address>();

        }

    }
    @GetMapping(value = "/id={ID}")
    public Address getAddress(@PathVariable(value = "ID") Integer intId) {
        try {
            return this.adrServ.getAddressById(intId);
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new Address();

        }

    }

    @PostMapping()
    public ResponseEntity addAddressToDataBase(@RequestBody Address address) {
        try {
            adrServ.addAddressToDataBase(address);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(PersonAlreadyExistsException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("Address doesn t exist,Can t add it again");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity deleteAddress(@PathVariable(value = "ID") Integer a) {
        try {
            return this.adrServ.delete(a);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("Address doesn t exist,Can t delete");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }

    }
    @PutMapping()
    public ResponseEntity updatePerson(@RequestBody Address address) {
        try {
            return this.adrServ.updateAddress(address);
        }catch(PersonDoesntExistException e){
            LOGGER.severe(e.getMessage());
            LOGGER.warning("address doesn t exist,Can t update");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
    }

}
