package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonAlreadyExistsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1L, "Lucian"), new Person(2L, "Mircea")));

    public List<Person> getPersonList() {
        return personList;
    }

    public boolean deletePerson(Person person) {
        return personList.remove(person);
    }

    public boolean addPerson(Person person) {
        if (personList.contains(person)) throw new PersonAlreadyExistsException("Persoana exista deja in DB");
        personList.add(person);
        return true;
    }

    public Optional<Person> findById(Long id) {
        return personList.stream().filter(p -> p.getId().longValue() == id).findFirst();
    }


}
