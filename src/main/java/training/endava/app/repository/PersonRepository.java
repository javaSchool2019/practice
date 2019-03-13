package training.endava.app.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;

import javax.swing.text.html.Option;

@Repository
public class PersonRepository {

    private List<Person> listOfPerson ;
    public PersonRepository() {

        listOfPerson = new ArrayList<>(Arrays.asList(new Person(1, "Person", "Unu"),
                new Person(2, "Person", "Doi"), new Person(3, "Person", "Trei")));
    }
    public List<Person> getPersons() {
        return listOfPerson;
    }
    public void addPerson(Person person)
    {
        listOfPerson.add(person);
    }

    public Optional<Person> getPersonById (Integer id){
        return this.getPersons().stream().filter(p->p.getId().equals(id)).findFirst();
    }

    public ResponseEntity updatePerson(Person person) {

        Optional<Person> initialPerson =  this.getPersonById(person.getId());

        if(initialPerson.isPresent()) {
            this.listOfPerson.remove(initialPerson.get());
            this.listOfPerson.add(person);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity delete(Integer a) {
        Optional<Person> personOptional = getPersonById(a);

        if (personOptional.isPresent()) {
            this.listOfPerson.remove(personOptional.get());
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);

        }

    }

}

