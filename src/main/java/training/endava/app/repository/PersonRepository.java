package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonAlreadyExistsException;


import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        if (persons.contains(person))
            throw new PersonAlreadyExistsException();
        persons.add(person);
    }

    public void updatePerson(long id, Person person) {
        if(persons.contains(person))
            throw new PersonAlreadyExistsException();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == id)
                persons.set(i, person);
        }
    }

    public void delete(long id) {
        persons.removeIf(person -> person.getId() == id);
    }
}