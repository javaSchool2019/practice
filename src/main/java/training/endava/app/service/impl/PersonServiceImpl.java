package training.endava.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonNotFoundException;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " does not exist"));
    }

    @Override
    public void save(Person p) {
        personRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }

    @Override
    public void update(Long id, Person p) {
        personRepository.update(id, p);
    }
}
