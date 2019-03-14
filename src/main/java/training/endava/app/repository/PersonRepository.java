package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonAlreadyExistsExceptionChild;
import training.endava.app.logger.YellowPagesLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static training.endava.app.logger.YellowPagesLogger.LOGGER;

@Repository
public class PersonRepository {

    private List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();
    }

    public List<Person> getAll() {
        return persons;
    }

    public void addPerson(Person person) {
        if (persons.contains(person)){
            throw new PersonAlreadyExistsException();
        }
        persons.add(person);
        LOGGER.info("Person added in the database");
    }

    public void updatePerson(long id, Person person) {
        if(persons.contains(person)){
            throw new PersonAlreadyExistsExceptionChild();
        }
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == id){
                persons.set(i, person);
                LOGGER.info("Person successfully updated");
            }
        }
        LOGGER.warning("No such id was found, no person updated");
    }

    public void deletePerson(long id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
