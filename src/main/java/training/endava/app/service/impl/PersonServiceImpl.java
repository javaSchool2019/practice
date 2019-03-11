package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.exception.BadRequestException;
import training.endava.app.exception.ResourceNotFoundException;
import training.endava.app.payload.PersonPutDTO;
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
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person with id " + id + " not found."));
    }

    @Override
    public void add(Person person) {
        if (invalidParameters(person.getId(), person.getName(), person.getAge())) {
            throw new BadRequestException("Invalid values for Person object fields");
        }
        if (personRepository.existsById(person.getId())) {
            throw new BadRequestException("Person already exists");
        }
        personRepository.save(person);
    }

    @Override
    public void delete(long id) {
        personRepository.delete(id);
    }

    @Override
    public void update(long id, PersonPutDTO personDTO) {
        if (invalidParameters(id, personDTO.getName(), personDTO.getAge())) {
            throw new BadRequestException("Invalid values for Person object fields");
        }
        Person person = personDTO.toPerson(id);
        personRepository.save(person);
    }

    private boolean invalidParameters(long id, String name, int age) {
        return age < 0 || age > 130 || id < 0 || name == null;
    }
}
