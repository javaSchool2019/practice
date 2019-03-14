package training.endava.app.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import training.endava.app.controller.PersonController;
import training.endava.app.domain.Person;
import training.endava.app.filters.PersonDTO;
import training.endava.app.mappers.PersonMapper;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(Integer id){
        return this.personRepository.getPersonById(id);
    }

    public HttpStatus deletePersonById(Integer id){
        return this.personRepository.deletePersonById(id);
    }

    public List<?> getAllPersons(){
        return this.personRepository.getAllPersons().stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO).collect(Collectors.toList());
    }

    public HttpStatus addPerson(Person person){
        return this.personRepository.addPerson(person);
    }

    public HttpStatus replacePerson(Person person){
        return this.personRepository.replacePerson(person);
    }
    public HttpStatus updatePerson(Person person){
        return this.personRepository.replacePerson(person);
    }
}
