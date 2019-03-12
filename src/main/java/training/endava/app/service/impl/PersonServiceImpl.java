package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.domain.PersonDTO;
import training.endava.app.domain.PersonMapper;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
       return personRepository.getAll().stream().map(PersonMapper.INSTANCE::personToPersonDTO).collect(Collectors.toList());
    }

    @Override
    public void addPerson(Person person) {
        personRepository.addPerson(person);
    }

    @Override
    public void updatePerson(long id, Person person) {
        personRepository.updatePerson(id, person);
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deletePerson(id);
    }


}
