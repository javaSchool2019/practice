package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.DTOMapper.PersonMapper;
import training.endava.app.domain.Person;
import training.endava.app.domain.hibernateObjects.PersonInfo;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.HibernatePersonServiceImpl;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/hibernate")
public class HibernateSpringController {

    private static LogManager logManager = LogManager.getLogManager();
    private static Logger LOGGER = Logger.getLogger("servLogger");

    @Autowired
    private HibernatePersonServiceImpl serv;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Person>> getAll() {
        LOGGER.info("GET REQUEST /persons/getAll");
        return ResponseEntity.ok(serv.getAll());
    }

    @GetMapping(value = "/getById={ID}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getById(@PathVariable(value = "ID") Integer id) {
        LOGGER.info("GET REQUEST /persons/getById");
        return ResponseEntity.ok(PersonMapper.INSTANCE.persontoPersonDTO(serv.getById(id)));
    }

    @PostMapping(value = "/post")
    ResponseEntity postPerson(@RequestBody PersonInfo personInfo) {
        LOGGER.info("POST REQUEST /persons/post");
        if (personInfo.getId() == null || personInfo.getName() == null) {
            LOGGER.severe("IllegalArgumentException");
            throw new IllegalArgumentException("At least one parameter is invalid or not supplied");
        }
        serv.addNewPersonToDB(personInfo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/put")
    ResponseEntity putPerson(@RequestBody Person person) {
        LOGGER.info("PUT REQUEST /persons/put");
        serv.update(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete={ID}")
    ResponseEntity deletePerson(@PathVariable(value = "ID") Integer id) {
        LOGGER.info("DELETE REQUEST /persons/delete");
        serv.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}
