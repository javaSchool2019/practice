package training.endava.app.repository.jparepository;

import training.endava.app.domain.entity.Person;

import java.util.List;

public interface PersonRepository {
    void add(Person person);
    void delete(Person person);
    Person getById(Long id);
    List<Person> getAll();
    void update (Person person);
}
