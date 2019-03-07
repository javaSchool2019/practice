package training.endava.skeleton.repository;

import training.endava.skeleton.exception.ErrorCode;
import training.endava.skeleton.exception.PersonNotFoundException;
import training.endava.skeleton.model.Person;

import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person, Long> {
    private static List<Person> personList = MOCK_DB.getTable(Person.class);

    @Override
    public Person save(Person person) {
        if (!personList.contains(person) && person != null) {
            personList.add(person);
            return person;
        }
        throw new PersonNotFoundException("Person already exists or is null!", ErrorCode.PERSON_ALREADY_EXISTS_OR_NULL);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personList.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public boolean existsById(Long id) {
        return personList.stream().anyMatch(person -> person.getId().equals(id));
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public long count() {
        return personList.size();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Person> person = findById(id);
        person.ifPresent(p -> personList.remove(p));
        person.orElseThrow(() -> new PersonNotFoundException("Id is not found", ErrorCode.ID_NOT_FOUND));
    }

    @Override
    public void deleteAll() {
        personList.clear();
    }
}
