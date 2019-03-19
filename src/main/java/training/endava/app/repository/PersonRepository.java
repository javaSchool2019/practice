package training.endava.app.repository;

import training.endava.app.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> findAll();
    Optional<Person> findById(Long id);
    void save(Person p);
    void delete(Long id);
    void delete(Person p);
    void update(Long id, Person p);
}
