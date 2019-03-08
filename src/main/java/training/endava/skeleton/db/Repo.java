package training.endava.skeleton.db;


import training.endava.skeleton.SkeletonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repo implements SkeletonRepository<Person,Integer> {

    MockDB db =  MockDB.getInstance();
    ArrayList<Person> R =  (ArrayList)db.getTable(Person.class); //cast

    public Person save (Person id)
    {
        if(existsById(id.getId))
            throw new ExceptiaA("This id already exist!!!");
        R.add(id);
        return id;
    }




    public void deleteById(Integer id)
    {
        for(int i=0;i<R.size();i++)
        {
            if(R.get(i).getId == id)
            {
                R.remove(i);
            }
            else
            {
                throw new ExceptiaA("Nu exista!");
            }
        }
    }
    public void deleteAll()
    {
        R.clear();
    }
    public boolean existsById(Integer id)
    {
        for(Person person:R)
        {
         if(person.getId().equals(id))
         {
             System.out.println("This id EXIST!");
             return true;
         }
        }
        System.out.println("This id doesn't exist!");
        return false;
    }

    public long count()
    {
        return R.size();
    }
    public List<Person> findAll()
    {
        return R;
    }

    public Optional<Person> findById(Integer id)
    {
        for(int i=0;i<R.size();i++)
        {
            if(R.get(i).getId == id)
                return Optional.of(R.get(i));
        }
        return Optional.empty();
    }
}
