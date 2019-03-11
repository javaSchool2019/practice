package training.endava.app.service;

import training.endava.app.domain.Person;
import java.util.List;

public interface PersonService {
    Person findById (Integer id);
    void deleteById(Integer id);
    Person insertPerson(Person id);
    List<Person> findAll();
}
