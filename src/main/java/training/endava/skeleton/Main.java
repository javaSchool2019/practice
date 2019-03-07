package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){

        Person p1 = new Person("Ana01", 1, "0701", "Iasi01");
        Person p2 = new Person("Ana02", 2, "0702", "Iasi02");
        Person p3 = new Person("Ana03", 3, "0703", "Iasi03");
        Person p4 = new Person("Ana04", 4, "0704", "Iasi04");
        Person p5 = new Person("Ana05", 5, "0705", "Iasi05");
        Person p6 = new Person("Ana06", 6, "0706", "Iasi06");

        List<Person> personList = new ArrayList<>();

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        System.out.println("LIST 1:");
        System.out.println(personList);

        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class, personList);

        System.out.println("LIST 2:");
        System.out.println(mockDB.getTable(Person.class));

        PersonRepository personRepository = new PersonRepository();

        personRepository.save(new Person("Ana09", 10, "0706", "Iasi06") );
        personRepository.findById(10);

        System.out.println(personRepository.existsById(10));

    }
}
