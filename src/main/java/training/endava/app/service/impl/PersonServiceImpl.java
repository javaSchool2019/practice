package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonNotFoundException;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() throws SQLException {
        return personRepository.findAll();
    }

    @Override
    public Person findById(long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " not found."));
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(long id) {
        personRepository.delete(id);
    }

    @Override
    public void update(long id, Person person) {
        personRepository.update(id, person);
    }
}
