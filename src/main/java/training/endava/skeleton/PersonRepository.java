package training.endava.skeleton;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person , Integer> {

    private ArrayList<Person> persons = (ArrayList) MOCK_DB.getTable(Person.class);


    @Override
    public Person save(Person id)
    {
        if(persons.contains(id))
            throw new CustomException("Person already exists");
        persons.add(id);
        return id;
    }

    @Override
    public Optional<Person> findById(Integer id)
    {
        for (Person p : persons)
        {
            if(p.getId() == id)
                return Optional.of(p);
        }

        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id){
        for (Person p : persons)
        {
            if(p.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public List<Person> findAll()
    {
        return persons;
    }

    @Override
    public long count()
    {
        return persons.size();
    }

    @Override
    public void deleteById(Integer id)
    {
        Iterator<Person> pIterator = persons.iterator();
        while (pIterator.hasNext()){
            Person p = pIterator.next();

            if(p.getId().equals(id))
            {
                persons.remove(p);
                break;
            }
        }
        throw new CustomException("This element doesn't exist!");
    }

    @Override
    public void deleteAll() {

        if (persons.isEmpty()) {
            throw new CustomException("List is already empty");
        }

        persons.clear();
    }

}
