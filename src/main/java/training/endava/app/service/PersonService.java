package training.endava.app.service;

import training.endava.app.domain.Person;
import training.endava.app.domain.PersonDTO;

import java.util.List;


public interface PersonService {
        List<Person> getAllPersons();
        void addPerson(Person person);
        void updatePerson(long id, Person person);
        void deletePerson(long id);
}
