package training.endava.app.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;

import javax.swing.text.html.Option;

@Repository
public class PersonRepository {

    private static final Logger LOGGER = (Logger) Logger.getLogger(String.valueOf(PersonRepository.class));

    private List<Person> listOfPerson;

    public PersonRepository() {

        listOfPerson = new ArrayList<>(Arrays.asList());
    }

    public List<Person> getPersons() {
        return listOfPerson;
    }

    public void addPerson(Person person) throws PersonDoesntExistException {
        if (!listOfPerson.stream().filter(p -> p.getId().equals(person.getId())).findFirst().isPresent()) {

            listOfPerson.add(person);
        }
        else throw new PersonAlreadyExistsException();
    }

    public Optional<Person> getPersonById(Integer id) {
        return this.getPersons().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    public ResponseEntity updatePerson(Person person) throws PersonDoesntExistException {

        Optional<Person> initialPerson = this.getPersonById(person.getId());

        if (initialPerson.isPresent()) {
            this.listOfPerson.remove(initialPerson.get());
            this.listOfPerson.add(person);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else throw new PersonDoesntExistException();
    }

    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {


        if (getPersonById(a).isPresent()) {
            this.listOfPerson.remove(getPersonById(a).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            throw new PersonDoesntExistException();

        }

    }

}
