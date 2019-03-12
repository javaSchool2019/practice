package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import training.endava.app.domain.Person;
import training.endava.app.exception.exception.classes.PersonNotFound;
import training.endava.app.exception.exception.classes.PersonUpdateException;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getById(Integer id) {
        return personRepository.getById(id).orElseThrow(() -> new PersonNotFound("Person with " + id + " not found", HttpStatus.NOT_FOUND.value()));
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getList();
    }

    @Override
    public void addNewPersonToDB(Person person) {
        personRepository.add(person);
    }

    @Override
    public void update(Person person) {

        if(personRepository.getList().indexOf(person)==-1){
            throw new PersonUpdateException("Person not found",HttpStatus.NOT_FOUND.value());
        }
        personRepository.update(person, personRepository.getList().indexOf(person));
    }

    @Override
    public void delete(Integer id) {
        personRepository.delete(id);
    }
}
