package training.endava.app.service;

import training.endava.app.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(Long id);
    void save(Person p);
    void delete(Long id);
    void update(Long id, Person p);
}
