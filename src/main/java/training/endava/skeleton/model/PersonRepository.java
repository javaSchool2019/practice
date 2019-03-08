package training.endava.skeleton.model;
import training.endava.skeleton.SkeletonRepository;
import training.endava.skeleton.exceptions.PersonIdAlreadyExistException;
import training.endava.skeleton.exceptions.PersonIdNotFoundException;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person, Integer> {

    private List<Person> persons = MOCK_DB.getTable(Person.class);

    @Override
    public Person save (Person id){
        if (persons.contains(id)){
            throw new PersonIdAlreadyExistException(id.getId());
        }
        persons.add(id);
        return id;
    }

    @Override
    public Optional<Person> findById(Integer id){
        for (Person p :persons){
            if (p.getId().equals(id)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id){
        for (Person p  : persons){
            if (p.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Person> findAll(){
        return persons;
    }

    @Override
    public long count() {
        return persons.size();
    }


    @Override
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


    @Override
    public void deleteAll() {
        persons.clear();
    }


}
