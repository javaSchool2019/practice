package training.endava.app.service;

import training.endava.app.domain.Person;
import java.util.List;

public interface PersonService {
    Person getPersonById (Integer id);
    void removePerson(Integer id);
    Person addPerson(Person id);
    List<Person> listAllPersons();
    Person updatePerson(Person person);
}

