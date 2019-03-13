package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import training.endava.app.controller.exceptionHandling.DeleteException;
import training.endava.app.controller.exceptionHandling.GetPerson;
import training.endava.app.controller.exceptionHandling.PersonException;
import training.endava.app.controller.exceptionHandling.UpdateException;
import training.endava.app.domain.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> personList = new ArrayList<>();


    public PersonRepository()
    {
        Person p1 = new Person(1, "Name01" , "Adr 01");
        personList.add(p1);

        personList.add(new Person(2, "Name02" , "Adr 02"));
        personList.add(new Person(3, "Name03" , "Adr 03"));
        personList.add(new Person(4, "Name04" , "Adr 04"));
        personList.add(new Person(5, "Name05" , "Adr 05"));
        personList.add(new Person(6, "Name06" , "Adr 06"));
    }


    public List<Person> returnAll()
    {
        return personList;
    }

    // read
    public Person getById(Integer id)
    {
            for(Person p : personList)
            {
                if(p.getId() == id)
                {
                    return p;
                }
            }
            return null;
    }

    //create
    public void createNewPerson(Person person)
    {
        Person p = this.getById(person.getId());
        if(p == null){
            personList.add(person);
        }
    }

    //update
    public void updatePerson(Person person)
    {
        for(Person p : personList)
        {
            if(p.getId().equals(person.getId()))
            {
                p.setAddress(person.getAddress());
                p.setName(person.getName());
                return;
            }
        }
        ///
        throw new PersonException("Person not found");
    }

    //delete
    public void deletePerson(Integer id)
    {
        for (Iterator<Person> iter = personList.listIterator(); iter.hasNext(); ) {
            Person p = iter.next();
            if (p.getId().equals(id)) {
                iter.remove();
                return;
            }
        }
        throw  new DeleteException("person does not exist");
    }
}
