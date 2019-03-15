package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.database.Postgres;
import training.endava.app.domain.Person;
import training.endava.app.payload.mapper.PersonMapper;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAll(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(PersonMapper.INSTANCE.personToPersonDTO(personService.getPerson(id)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Connection conn;
        try {
            conn = Postgres.getConnection();
            System.out.println("S-a conectat");
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM test");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (Exception e) {
            System.out.println("Nu s-a conectat");
            e.printStackTrace();
        }


        return new ResponseEntity<>(personService.getAllPerson().stream().map(PersonMapper.INSTANCE::personToPersonDTO), HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.removePerson(id);
        return new ResponseEntity<>("Person was removed", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable long id, @Valid @RequestBody Person person) {
        personService.update(id, person);
        return new ResponseEntity<>("Person was modified", HttpStatus.OK);


    }


}
