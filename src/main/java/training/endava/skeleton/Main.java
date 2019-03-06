package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;
import training.endava.skeleton.exceptions.CustomPersonException;
import training.endava.skeleton.models.Person;
import training.endava.skeleton.repositories.PersonRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void printPersons(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    public static List<Person> createDummyPersonList() {
        Person p1 = new Person(1, "Name1", "0733444555", "Address1");
        Person p2 = new Person(2, "Name2", "0733444555", "Address2");
        Person p3 = new Person(3, "Name3", "0733444555", "Address3");
        Person p4 = new Person(4, "Name4", "0733444555", "Address4");
        Person p5 = new Person(5, "Name5", "0733444555", "Address5");
        return Arrays.asList(p1, p2, p3, p4, p5);
    }

    public static void main(String[] args) {
        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class,createDummyPersonList());
        List<Person> persons = mockDB.getTable(Person.class);
        System.out.println("Initial persons:");
        printPersons(persons);
        System.out.println("-------------------------------------");

        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        Person p6 = personRepository.save(new Person(6, "Name6", "0733444555", "Address6"));
        System.out.println("Adding person: " + p6);
        System.out.println("Persons count: " + personRepository.count());
        System.out.println("Find person with id 3: " + personRepository.findById(3));
        System.out.println("Find person with id 10: " + personRepository.findById(10));
        System.out.println("Person with id 3 exists: " + personRepository.existsById(3));
        System.out.println("Person with id 10 exists: " + personRepository.existsById(10));
        System.out.println("Deleting person with id 3");
        personRepository.deleteById(3);
        System.out.println("Person with id 3 exists " + personRepository.existsById(3));
        System.out.println("Deleting person with id 3:");
        try{
            personRepository.deleteById(3);
        } catch (CustomPersonException e){
            System.out.println("EXCEPTION: " + e.getMessage()+ ", error code " + e.getErrorCode());
        }
        try {
            personRepository.save(p6);
        } catch (CustomPersonException e){
            System.out.println("EXCEPTION: " + e.getMessage() + ", error code " + e.getErrorCode());
        }
        try {
            personRepository.save(null);
        } catch (CustomPersonException e){
            System.out.println("EXCEPTION: " + e.getMessage() + ", error code " + e.getErrorCode());
        }
        System.out.println("Person list with findAll:");
        printPersons(personRepository.findAll());
        personRepository.deleteAll();
        System.out.println("Persons count after deleteAll: " + personRepository.count());

    }
}
