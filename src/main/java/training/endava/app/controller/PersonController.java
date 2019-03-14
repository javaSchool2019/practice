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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private static LogManager logManager = LogManager.getLogManager();
    private static Logger LOGGER = Logger.getLogger("servLogger");

    static {
        try {
            FileHandler file = new FileHandler("./src/main/resources/loggerServer.log", true);
            file.setFormatter(new SimpleFormatter());
            file.setLevel(Level.INFO);

            Handler console = new ConsoleHandler();
            console.setLevel(Level.SEVERE);

            LOGGER.addHandler(file);
            LOGGER.addHandler(console);

        } catch (IOException exception) {
            exception.fillInStackTrace();
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
    }

    @Autowired
    private PersonService serv;

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
    ResponseEntity postPerson(@RequestBody Person person) {
        LOGGER.info("GET REQUEST /persons/post");
        if (person.getId() == null || person.getName() == null) {
            LOGGER.severe("IllegalArgumentException");
            throw new IllegalArgumentException("At least one parameter is invalid or not supplied");
        }
        serv.addNewPersonToDB(person);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/put")
    ResponseEntity putPerson(@RequestBody Person person) {
        LOGGER.info("GET REQUEST /persons/put");
        serv.update(person);
        return ResponseEntity.ok(PersonMapper.INSTANCE.persontoPersonDTO(serv.getById(person.getId())));
    }

    @DeleteMapping("/delete={ID}")
    ResponseEntity deletePerson(@PathVariable(value = "ID") Integer id) {
        LOGGER.info("GET REQUEST /persons/delete");
        serv.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
