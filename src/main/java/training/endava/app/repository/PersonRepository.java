package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import training.endava.app.domain.Person;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class PersonRepository {
    private List<Person> list = new ArrayList<Person>();

    public PersonRepository() {
        list.add(new Person("nume1", 1));
        list.add(new Person("nume2", 2));
        list.add(new Person("nume3", 3));
        list.add(new Person("nume4", 4));
        list.add(new Person("nume5", 5));
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Optional<Person> getById(Integer id) {
        Optional<Person> op = list.stream().filter(y -> y.getId().equals(id)).findFirst();
        return op;
    }

    public void add(Person person) {
        list.add(person);
    }

    public void update(Person person, Integer i) {
        list.set(i, person);
    }

    public void delete(Integer personId) {
        list.remove(list.get(personId));
    }
}