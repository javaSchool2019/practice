package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonDeleteException;

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

    private static long lastIndex = 4;

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
        person.setId(++lastIndex);
        MOCK_DB.add(person);
    }

    public void update(long id, Person person){
        if (!existsById(id)){
            save(person);
        }
        else{
            Person p = findById(id).orElse(new Person());
            p.setName(person.getName());
            p.setAge(person.getAge());
        }
    }

    public void delete(long id) {
        Person person = findById(id).orElseThrow(() -> new PersonDeleteException("Person with id " + id + " does not exist"));
        MOCK_DB.remove(person);
    }
}
