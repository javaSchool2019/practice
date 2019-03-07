package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        List<Person> yellowPageContacts = new ArrayList<>();
        Person p1 = new Person(UUID.randomUUID(), "Popescu", "01234556789", "Iasi");
        Person p2 = new Person(UUID.randomUUID(), "Ionescu", "01234556789", "Iasi");
        Person p3 = new Person(UUID.randomUUID(), "Escu", "01234556789", "Iasi");
        Person p4 = new Person(UUID.randomUUID(), "Liliescu", "01234556789", "Iasi");
        Person p5 = new Person(UUID.randomUUID(), "Pop", "01234556789", "Iasi");

        yellowPageContacts.add(p1);
        yellowPageContacts.add(p2);
        yellowPageContacts.add(p3);
        yellowPageContacts.add(p4);
        yellowPageContacts.add(p5);

        for (Person contact : yellowPageContacts){
            System.out.println(contact);
        }
        System.out.println();

        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class, yellowPageContacts);

        List<Person> dbContacts = mockDB.getTable(Person.class);
        for(Person person : dbContacts){
            System.out.println(person);
        }

        System.out.println();

        PersonRepository personRepository = new PersonRepository();
        Person p6 = new Person(UUID.randomUUID(), "Popovici", "01234556789", "Iasi");
        personRepository.save(p6);


        Optional<Person> optionalPerson = personRepository.findById(p6.getId());
        Person person = optionalPerson.isPresent() ? optionalPerson.get() : null;
        System.out.println(person);

        Optional<Person> optionalPerson1 = personRepository.findById(UUID.randomUUID());
        Person person1 = optionalPerson1.isPresent() ? optionalPerson1.get() : null;
        System.out.println(person1);

        boolean existsPerson = personRepository.existsById(p6.getId());
        boolean existsPerson1 = personRepository.existsById(UUID.randomUUID());
        System.out.println(existsPerson + " " + existsPerson1);

        List<Person> personList = personRepository.findAll();
        System.out.println(personList);

        long personCount = personRepository.count();
        System.out.println(personCount);

        personRepository.deleteById(p1.getId());
        personCount = personRepository.count();
        System.out.println(personCount);

        try{
            personRepository.save(null);
            System.out.println("blah: " + personRepository.findAll());
        }
        catch (ElementException exception){
            exception.printStackTrace();
        }

        try{
            personRepository.save(p2);
        }
        catch (ElementException exception){
            exception.printStackTrace();
        }
        System.out.println(personRepository.count());

        personRepository.deleteAll();
        personCount = personRepository.count();
        System.out.println(personCount);
    }
}
