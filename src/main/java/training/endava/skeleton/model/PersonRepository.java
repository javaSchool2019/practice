package training.endava.skeleton.model;
import training.endava.skeleton.SkeletonRepository;
import training.endava.skeleton.exceptions.PersonIdAlreadyExistException;
import training.endava.skeleton.exceptions.PersonIdNotFoundException;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person, Integer> {

//    ArrayList<Person> persons= (ArrayList) MOCK_DB.getTable(Person.class);

    List<Person> persons;

    public PersonRepository(List<Person> persons) {
        this.persons = persons;
    }

    public Person save (Person id){
        if (persons.contains(id)){
            throw new PersonIdAlreadyExistException(id.getId());
        }
        persons.add(id);
        return id;
    }

    public Optional<Person> findById(Integer id){
        for (Person p :persons){
            if (p.getId().equals(id)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public boolean existsById(Integer id){
        for (Person p  : persons){
            if (p.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public List<Person> findAll(){
        return persons;
    }

    public long count() {
        return persons.size();
    }


    public void deleteById(Integer id) {
        if (!existsById(id)) throw new PersonIdNotFoundException(id);
        Iterator<Person> personIterator=persons.iterator();

        while(personIterator.hasNext()){
            Person p=personIterator.next();
            if (p.getId().equals(id)){
                persons.remove(p);
                break;
            }
        }
    }


    public void deleteAll() {
        persons.clear();
    }


}
