package training.endava.app.repository;

import training.endava.app.domain.Person;

import java.util.List;

public class StubPersonRepository extends PersonRepository {

    private List<Person> personList;

    public StubPersonRepository(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }
}
