package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonNotFoundException;
import training.endava.app.payload.PersonDTO;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
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
    public void update(long id, PersonDTO personDTO) {
        personRepository.update(id, personDTO.toPerson());
    }
}
