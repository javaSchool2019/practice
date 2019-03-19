package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> returnAll()
    {
        return this.personRepository.returnAll();
    }

    public Person getById(int id)
    {
        return this.personRepository.getById(id);
    }

    public void deleteById(int id)
    {
        this.personRepository.deletePerson(id);
    }

    public void updatePerson(Person person)
    {
        this.personRepository.updatePerson(person);
    }

    public void createNewPerson(Person person)
    {
        this.personRepository.createNewPerson(person);
    }

}
