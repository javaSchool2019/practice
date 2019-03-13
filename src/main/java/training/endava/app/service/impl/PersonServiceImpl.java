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
    PersonRepository personRepository;


    @Override
    public Person getPersonById (Integer id) {
        return this.personRepository.getPersonById(id);
    }

    @Override
    public void removePerson(Integer id) {
        this.personRepository.removePerson(id);
    }

    @Override
    public Person addPerson(Person id){
        return  this.personRepository.addPerson(id);
    }

    @Override
    public List<Person> listAllPersons(){
        return this.personRepository.findAllPersons();
    }

    @Override
    public Person updatePerson(Person person){
        return  this.personRepository.updatePerson(person);

    }

}

