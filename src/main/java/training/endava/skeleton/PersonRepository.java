package training.endava.skeleton;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonRepository implements SkeletonRepository<Person, UUID> {

    private List<Person> persons = MOCK_DB.getTable(Person.class);

    @Override
    public Person save(Person person) {
        if(person == null){
            throw new ElementException(ElementException.ElementErrors.NULL_ELEMENT);
        }
        if(!persons.contains(person)){
            persons.add(person);
            MOCK_DB.setTable(Person.class, persons);
            return person;
        }
        throw new ElementException(ElementException.ElementErrors.DUPLICATE_ELEMENT);
    }

    @Override
    public Optional<Person> findById(UUID uuid) {
        return persons.stream().filter(p -> p.getId().equals(uuid)).findAny();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return persons.stream().anyMatch(p -> p.getId().equals(uuid));
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
    public void deleteById(UUID uuid) {
        persons.removeIf(p -> p.getId().equals(uuid));
    }

    @Override
    public void deleteAll() {
       persons.clear();
    }
}
