package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import training.endava.app.controller.exceptionHandling.DeleteException;
import training.endava.app.controller.exceptionHandling.PersonException;
import training.endava.app.domain.Person;
import training.endava.app.logger.MyLogger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.*;

@Repository
public class PersonRepository {

    private static MyLogger logger = MyLogger.getInstance();
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
        logger.log(Level.INFO, "Searching for a list");
        return personList;
    }

    // read
    public Person getById(Integer id)
    {
        logger.log(Level.INFO, "Starting to do iterate the list...");

            for(Person p : personList)
            {
                if(p.getId() == id)
                {
                    logger.log(Level.INFO, "element has been found");
                    return p;
                }
            }

        logger.log(Level.WARNING,"element not found ");

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
        try {
            throw new PersonException("Person Exception");
        }
        catch (PersonException p)
        {
            logger.log(Level.SEVERE, "Person not found", p );
        }
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
