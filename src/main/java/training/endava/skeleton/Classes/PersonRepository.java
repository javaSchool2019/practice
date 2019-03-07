package training.endava.skeleton.Classes;

import training.endava.skeleton.Exceptions.IncorectRuntimeException;
import training.endava.skeleton.Interfaces.SkeletonRepository;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person, Integer> {


    @Override
    public Person save(Person id) {
        if(existsById(id.getId()))
            throw new IncorectRuntimeException("Person with id " + id.getId() + " already exists.");

        MOCK_DB.getTable(Person.class).add(id);
        return id;
    }

    @Override
    public Optional<Person> findById(Integer integer) {

        for(Person person: MOCK_DB.getTable(Person.class)){
            if(person.getId().equals(integer)){
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {

        for(Person person: MOCK_DB.getTable(Person.class)){
            if(person.getId().equals(integer)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Person> findAll() {
        return MOCK_DB.getTable(Person.class);
    }

    @Override
    public long count() {
        return MOCK_DB.getTable(Person.class).size();
    }

    @Override
    public void deleteById(Integer integer){

        Iterator<Person> personIterator = MOCK_DB.getTable(Person.class).iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if(person.getId().equals(integer)){
                MOCK_DB.getTable(Person.class).remove(person);
                return;
            }
        }
        throw new IncorectRuntimeException("Person with id " + integer + " was not found in the list and cannot be removed.");
    }

    @Override
    public void deleteAll() {
        MOCK_DB.getTable(Person.class).clear();
    }
}
