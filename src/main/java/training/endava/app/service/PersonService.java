package training.endava.app.service;

import org.springframework.http.HttpStatus;
import training.endava.app.domain.Person;

import java.util.List;

public interface PersonService {

    Person getPersonById(Integer id);
    HttpStatus deletePersonById(Integer id);
    List<?> getAllPersons();
    HttpStatus addPerson(Person person);
    HttpStatus replacePerson(Person person);
}
