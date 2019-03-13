package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import sun.dc.path.PathError;
import training.endava.app.domain.Person;
import training.endava.app.exceptions.PersonIdAlreadyExistException;
import training.endava.app.exceptions.PersonIdNotExistException;

import java.util.*;


@Repository
public class PersonRepository {

    List<Person> persons=new ArrayList<>();

    public PersonRepository() {
        Person p1=new Person(1,"Name 1","name1@something.com","074XXXXXX1", "Address 1");
        Person p2=new Person(2,"Name 2","name2@something.com","074XXXXXX2", "Address 2");
        Person p3=new Person(3,"Name 3","name3@something.com","074XXXXXX3", "Address 3");
        Person p4=new Person(4,"Name 4","name4@something.com","074XXXXXX4", "Address 4");
        Person p5=new Person(5,"Name 5","name5@something.com","074XXXXXX5", "Address 5");
        Person p6=new Person(6,"Name 6","name6@something.com","074XXXXXX6", "Address 6");
        Person p7=new Person(7,"Name 7","name7@something.com","074XXXXXX7", "Address 7");
        Person p8=new Person(8,"Name 8","name8@something.com","074XXXXXX8", "Address 8");
        Person p9=new Person(9,"Name 9","name9@something.com","074XXXXXX9", "Address 9");
        this.persons.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));
    }


    public Person getPersonById(Integer id){
        Optional<Person> personById = persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if(!personById.isPresent()){
            throw new PersonIdNotExistException(id); }
        return personById.get();
    }


    public void removePerson(Integer id) {
        Iterator<Person> personIterator=persons.iterator();

        while(personIterator.hasNext()){
            Person p=personIterator.next();
            if (p.getId().equals(id)){
                persons.remove(p);
                break;
            }
        }
    }


    public Person addPerson (Person id){
        if (persons.contains(id)){
            throw new PersonIdAlreadyExistException(id.getId());
        }
        persons.add(id);
        return id;
    }


    public List<Person> findAllPersons(){
        return persons;
    }

    public Person updatePerson(Person person){
        for (Person p:persons){
            if(p.getId().equals(person.getId())){
                p.setName(person.getName());
                p.setEmail(person.getEmail());
                p.setPhone(person.getPhone());
                p.setAddress(person.getAddress());
                return p;
            }
        }
        return null;
    }


}
