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
    public Person findById (Integer id) {
        return this.personRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public Person insertPerson(Person id){
        return  this.personRepository.insertPerson(id);
    }

    @Override
    public List<Person> findAll(){
        return this.personRepository.findAll();
    }

}
