package training.endava.skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements SkeletonRepository<Person,Integer> {


    List<Person> p1= MOCK_DB.getTable(Person.class);

    public void deleteAll(){
        p1.clear();
    }

     public void deleteById(Integer id){
        boolean ob=false;
         for(int i=0;i<p1.size();i++) {
            if(p1.get(i).getId()==id){
                p1.remove(i);
                ob=true;
            }

         }
         if(ob==false) throw new ExceptiaMea();
     }
    public long count(){
    return p1.size();

    }

   public List<Person> findAll(){

        return p1;

   }

    public boolean existsById(Integer id){

        Boolean b=false;
        for(int i=0;i<p1.size();i++) {
            if (p1.get(i).getId() == id)
                b=true;


        }

    return b;

    }

    public Optional<Person> findById(Integer id){

        for(int i=0;i<p1.size();i++){
            if (p1.get(i).getId() == id)
                return Optional.of(p1.get(i));
        }
    return Optional.empty();
    }

    public Person save(Person id){

        if(!p1.contains(id) && id!=null) {
            p1.add(id);
            return id;
        }
        throw new ExceptiaMea();

    }


}

