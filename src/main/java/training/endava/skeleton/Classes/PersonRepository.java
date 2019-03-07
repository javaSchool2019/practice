package training.endava.skeleton.Classes;

import training.endava.skeleton.Exceptions.IncorectRuntimeException;
import training.endava.skeleton.Interfaces.SkeletonRepository;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person, Integer> {

    List<Person> personList;

    public PersonRepository() {
        this.personList = MOCK_DB.getTable(Person.class);
    }

    @Override
    public Person save(Person id) {
        if(existsById(id.getId()))
            throw new IncorectRuntimeException("Person with id " + id.getId() + " already exists.");
        this.personList.add(id);
        return id;
    }

    @Override
    public Optional<Person> findById(Integer integer) {
        for(Person person: this.personList){
            if(person.getId().equals(integer)){
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        for(Person person: this.personList){
            if(person.getId().equals(integer)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Person> findAll() {
        return this.personList;
    }

    @Override
    public long count() {
        return Long.valueOf(this.personList.size());
    }

    @Override
    public void deleteById(Integer integer){
        Iterator<Person> personIterator = this.personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if(person.getId().equals(integer)){
                this.personList.remove(person);
                return;
            }
        }
        throw new IncorectRuntimeException("Person with id " + integer + " was not found in the list and cannot be removed.");
    }

    @Override
    public void deleteAll() {
        this.personList.clear();
    }
}
