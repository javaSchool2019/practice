package training.endava.app.repository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.exceptions.BadRequestException;
import training.endava.app.exceptions.BaseException;
import training.endava.app.exceptions.PersonAlreadyExists;
import training.endava.app.exceptions.PersonNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private List<Person> personList = null;

    public PersonRepository(){
        this.personList = new ArrayList<>();
        Person p1 = new Person(1, "Irimia Cosmin", "0756735362", "Iasi");
        Person p2 = new Person(2, "Matei Madalin", "07689394394", "Bacau");
        Person p3 = new Person(3, "Bucevschi Alexandru", "07539192833", "Botosani");
        Person p4 = new Person(4, "Trinca Ioana", "0749287483", "Iasi");
        Person p5 = new Person(5, "Olariu Madalina", "07516738483", "Vaslui");
        Person p6 = new Person(6, "Cineva Marcel", "07576738483", "Bacau");
        this.personList.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
    }

    public Person getPersonById(Integer id){
        Optional<Person> p = this.personList.stream().filter(person -> person.getId().equals(id)).findFirst();
        if(p.isPresent()){
            return p.get();
        }
        return null;
    }

    public List<Person> getAllPersons(){
        return this.personList;
    }

    public HttpStatus addPerson(Person person){
        if(this.getPersonById(person.getId()) == null){
            this.personList.add(person);
            return HttpStatus.CREATED;
        }else {
            throw new PersonAlreadyExists("Person already exists.");
        }
    }

    public HttpStatus replacePerson(Person person){
        Person p = this.getPersonById(person.getId());
        if(p == null){
            throw new PersonNotFoundException("Person you try to replace does not exists.");
        }else {
            this.personList.remove(p);
            this.personList.add(person);
            return HttpStatus.OK;
        }
    }

    public HttpStatus updatePerson(Person person){
        if(person.getId()==null){
            throw new BadRequestException("Bad request. Please provide a person with Id.");
        }
        Person p = this.getPersonById(person.getId());
        if(p == null){
            throw new PersonNotFoundException("Person you try to update does not exists.");
        }else {
            if(person.getName()!=null){
                p.setName(person.getName());
            }
            if(person.getAdress()!=null){
                p.setAdress(person.getAdress());
            }
            if(person.getPhoneNumber()!=null){
                p.setPhoneNumber(person.getPhoneNumber());
            }
            return HttpStatus.OK;
        }
    }

    public HttpStatus deletePersonById(Integer id){
        Person p = this.getPersonById(id);
        if(p == null){
            throw new BaseException("Person you try to delete does not exists.");
        }else {
            this.personList.remove(p);
            return HttpStatus.OK;
        }
    }
}
