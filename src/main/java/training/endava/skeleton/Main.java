package training.endava.skeleton;

import training.endava.skeleton.exception.PersonNotFoundException;
import training.endava.skeleton.model.Person;
import training.endava.skeleton.repository.PersonRepository;
import training.endava.skeleton.repository.SkeletonRepository;
import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MockDB dataBase = MockDB.getInstance();
        dataBase.setTable(Person.class, createDummyData());
        List<Person> personList = dataBase.getTable(Person.class);

        SkeletonRepository<Person, Long> personRepository = new PersonRepository();

        Person person = personRepository.findById(6L).get();
        System.out.println("Find by id: " + person);
        System.out.println("Size of the table Person: " + personRepository.count());
        System.out.println("Content: " + personRepository.findAll());
        System.out.println("Person with ID = 5: " + personRepository.existsById(5L));

        try {
            personRepository.save(new Person(7L, "Nike", "0865345", "Address7"));

        } catch (PersonNotFoundException personNotFoundExeption) {
            personNotFoundExeption.printStackTrace();
        }

        try {
            personRepository.deleteById(7L);
        } catch (PersonNotFoundException personNotFoundExeption) {
            personNotFoundExeption.printStackTrace();
            System.out.println(personNotFoundExeption.getMessage() + " ErrorCode: " + personNotFoundExeption.getErrorCode());
        }

        personList.forEach(System.out::println);
        personRepository.deleteAll();
        personList.forEach(System.out::println);
    }

    private static List<Person> createDummyData() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L, "Lucian", "086536", "Address1"));
        personList.add(new Person(2L, "Mircea", "045433", "Address2"));
        personList.add(new Person(3L, "Iulian", "087436", "Address3"));
        personList.add(new Person(4L, "Timmy", "087543", "Address4"));
        personList.add(new Person(5L, "Claus", "086656", "Address5"));
        personList.add(new Person(6L, "Mark", "0865345", "Address6"));

        return personList;
    }
}
