package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.exception.BadRequestException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private static List<Person> MOCK_DB = new ArrayList<>(Arrays.asList(
            new Person(1L, "Person1", 18),
            new Person(2L, "Person2", 20),
            new Person(3L, "Person3", 27),
            new Person(4L, "Person4", 35)));

    public Optional<Person> findById(long id) {
        return MOCK_DB.stream().filter(p -> p.getId() == id).findFirst();
    }

    public boolean existsById(long id) {
        return findById(id).isPresent();
    }

    public List<Person> findAll() {
        return MOCK_DB;
    }

    public void save(Person person) {
        boolean found = false;
        for (Person p : MOCK_DB) {
            if (p.getId().equals(person.getId())) {
                p.setName(person.getName());
                p.setAge(person.getAge());
                found = true;
            }
        }
        if (!found) {
            MOCK_DB.add(person);
        }
    }

    public void delete(long id) {
        Person person = findById(id).orElseThrow(() -> new BadRequestException("Person with id " + id + " does not exist"));
        MOCK_DB.remove(person);
    }
}
