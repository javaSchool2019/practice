package training.endava.app.service;

import training.endava.app.domain.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    List<Person> findAll() throws SQLException;

    Person findById(long id);

    void add(Person person);

    void delete(long id);

    void update(long id, Person person);
}
