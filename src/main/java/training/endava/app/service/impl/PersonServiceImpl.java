package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.myException;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repo;

    public Optional<Person> getPersonById (Integer id) throws myException {
        if(id<0) {
            throw new myException("Wrong ID!!");
        }
        else
        {
            return repo.getPersons().stream().filter(p -> p.getId().equals(id)).findFirst();
        }
    }

    public void addPerson(Person person){
        repo.addPerson(person);
    }

    public ResponseEntity updatePerson(Person person) {
        return repo.updatePerson(person);
    }

    public List<Person> getAllPersons ()
    {
        return repo.getPersons();
    }

    public ResponseEntity delete(Integer a) {

        return this.repo.delete(a);

    }
}

