package training.endava.skeleton.repositories;

import training.endava.skeleton.SkeletonRepository;
import training.endava.skeleton.exceptions.CustomPersonException;
import training.endava.skeleton.models.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl implements SkeletonRepository<Person, Integer> {
    private static LinkedList<Person> persons = new LinkedList<>(MOCK_DB.getTable(Person.class));

    @Override
    public Person save(Person id) {
        if (id != null) {
            if (existsById(id.getId())) {
                throw new CustomPersonException("Person with id " + id.getId() + " already exists",
                        CustomPersonException.PERSON_ALREADY_EXISTS);
            }
            persons.add(id);
            MOCK_DB.setTable(Person.class, persons);
        } else {
            throw new CustomPersonException("Invalid user to add", CustomPersonException.ILLEGAL_ARGUMENT);
        }
        return id;
    }

    @Override
    public Optional<Person> findById(Integer integer) {
        return persons.stream().filter(p -> p.getId().equals(integer)).findFirst();
    }

    @Override
    public boolean existsById(Integer integer) {
        return persons.stream().anyMatch(p -> p.getId().equals(integer));
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public long count() {
        return persons.size();
    }

    @Override
    public void deleteById(Integer integer) {
        persons.remove(findById(integer).orElseThrow(() -> new CustomPersonException("Person with id " + integer
                + " does not exist", CustomPersonException.PERSON_NOT_FOUND)));
        MOCK_DB.setTable(Person.class, persons);
    }

    @Override
    public void deleteAll() {
        persons.clear();
        MOCK_DB.setTable(Person.class, persons);
    }
}
