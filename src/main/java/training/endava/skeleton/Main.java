package training.endava.skeleton;

import training.endava.skeleton.Classes.Person;
import training.endava.skeleton.Classes.PersonRepository;
import training.endava.skeleton.Exceptions.IncorectSomethingException;
import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String argv[]){
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person(1, "Irimia Cosmin", "0756735362", "Iasi");
        Person p2 = new Person(2, "Matei Madalin", "07689394394", "Bacau");
        Person p3 = new Person(3, "Bucevschi Alexandru", "07539192833", "Botosani");
        Person p4 = new Person(4, "Trinca Ioana", "0749287483", "Iasi");
        Person p5 = new Person(5, "Olariu Madalina", "07516738483", "Vaslui");
        //Person p6 = new Person(6, "Olariu Madalina", "07516738483", "Vaslui");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);




        //personList.forEach(System.out::println);

        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class, personList);
        //mockDB.getTable(Person.class).forEach(System.out::println);

        PersonRepository personRepository = new PersonRepository();
        System.out.println(personRepository.findById(1));

        personRepository.save(new Person(6, "Olariu Madalina", "07516738483", "Vaslui"));
        System.out.println(personRepository.findById(6));

        personRepository.findAll().forEach(System.out::println);



    }

}
