package training.endava.app.service;



import training.endava.app.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public Person getById(Integer id);
    public List<Person> getAll();
    public void addNewPersonToDB(Person person);
    public void update(Person person);
    public void delete(Integer id);
}
