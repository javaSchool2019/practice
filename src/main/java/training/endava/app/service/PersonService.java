package training.endava.app.service;

import org.springframework.stereotype.Component;
import training.endava.app.domain.entity.Person;


import java.util.List;

@Component
public interface PersonService {
    boolean addPerson(Person person);
    boolean removePerson(Long id);
    boolean update (Long id, Person person);
    List<Person> getAllPerson();
    Person getPerson(Long id);

}
