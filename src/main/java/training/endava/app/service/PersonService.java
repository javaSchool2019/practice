package training.endava.app.service;

import training.endava.app.domain.Person;
import training.endava.app.payload.PersonDTO;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(long id);
    void add(Person person);
    void delete(long id);
    void update(long id, PersonDTO personDTO);
}
