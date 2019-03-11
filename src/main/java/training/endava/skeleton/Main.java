package training.endava.skeleton;

import training.endava.skeleton.exception.PersonNotFoundException;
import training.endava.skeleton.model.Person;
import training.endava.skeleton.repository.PersonRepository;
import training.endava.skeleton.repository.SkeletonRepository;
import training.endava.skeleton.db.MockDB;


import java.time.Duration;
import java.time.Instant;
import java.time.Year;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MockDB dataBase = MockDB.getInstance();

        dataBase.setTable(Person.class, createDummyData());
        List<Person> personList = dataBase.getTable(Person.class);

        SkeletonRepository<Person, Long> personRepository = new PersonRepository();

        PersonRepository p2 = new PersonRepository();
        int count = (int) p2.count();
        Person person = personRepository.findById(6L).get();
        System.out.println("Find by id: " + person);
        System.out.println("Size of the table Person: " + personRepository.count());
        System.out.println("Content: " + personRepository.findAll());
        System.out.println("Person with ID = 5: " + personRepository.existsById(5L));

        try {
            personRepository.save(new Person(7L, "Nike", "0865345", "Address7", new Company("CompanyFinance", Year.of(2000), Area.FINANCE)));


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


        List<Company> companies = createDummyDataCompany();
        System.out.println("----------------Ex1------------------");
        companies.forEach(System.out::println);
        System.out.println("----------------Ex2------------------");
        companies.stream().map(Company::getFoundationYear).mapToInt(Year::getValue).max().ifPresent(System.out::println);
        System.out.println("-----------EX3-------------");
        companies.stream().min((o1, o2) -> o1.getFoundationYear().compareTo(o2.getFoundationYear())).ifPresent(System.out::println);
        System.out.println("-----------EX4-------------");
        System.out.println("Number of persons: " + companies.stream().mapToInt(company -> company.getPersonList().size()).reduce(0, (o1, o2) -> o1 + o2));

        System.out.println("-----------EX5-------------");
        Person person1 = companies.stream()
                .map(Company::getPersonList)
                .flatMap(List<Person>::stream)
                .reduce(new Person(), (o1, o2) -> {
                    o2.setName(o1.getName() + o2.getName());
                    return o2;
                });

        System.out.println(person1);
        System.out.println("-----------EX6-------------");
        companies.stream().map(Company::getPersonList)
                .flatMap(List<Person>::stream)
                .forEach(System.out::println);

        System.out.println("----------EX7-------------");
        companies.stream().map(Company::getPersonList)
                .flatMap(List<Person>::stream).distinct().forEach(System.out::println);

        System.out.println("----------EX8-------------");
        Collector<Person, StringJoiner, String> personCollector =
                Collector.of(
                        () -> new StringJoiner(", ", "Prefix", "Suffix"),
                        (supp, person2) -> supp.add(person2.getName().toUpperCase()),
                        StringJoiner::merge,
                        StringJoiner::toString
                );

        String names = companies.stream().map(Company::getPersonList)
                .flatMap(List<Person>::stream).collect(personCollector);
        System.out.println(names);

        System.out.println("----------EX9-------------");
        Instant startTime;
        startTime = Instant.now();
        Stream.iterate(0, i -> i + 1).limit(500000).filter(i -> i % 2 == 0).count();
        System.out.println("NonParalel: " + Duration.between(Instant.now(), startTime).getSeconds());

        startTime = Instant.now();
        Stream.iterate(0, i -> i + 1).limit(500000).parallel().filter(i -> i % 2 == 0).count();
        System.out.println("Paralel: " + Duration.between(Instant.now(), startTime).getSeconds());


    }

    private static List<Company> createDummyDataCompany() {
        List<Company> companies = new ArrayList<>();
        Company companyFinance = new Company("CompanyFinance", Year.of(2000), Area.FINANCE);
        Company companyIt = new Company("CompanyIt", Year.of(2005), Area.IT);

        companies.add(companyFinance);
        companies.add(companyIt);

        companyFinance.addPerson(new Person(1L, "Lucian", "086536", "Address1", companyFinance));
        companyFinance.addPerson(new Person(2L, "Mircea", "086536", "Address2", companyFinance));
        companyFinance.addPerson(new Person(3L, "Iulian", "087436", "Address3", companyFinance));
        companyIt.addPerson(new Person(4L, "Timmy", "087543", "Address4", companyIt));
        companyIt.addPerson(new Person(5L, "Claus", "086656", "Address5", companyIt));
        companyFinance.addPerson(new Person(6L, "Mark", "0865345", "Address6", companyFinance));

        return companies;
    }

    private static List<Person> createDummyDataPerson() {
        Company companyFinance = new Company("CompanyFinance", Year.of(2000), Area.FINANCE);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L, "Lucian", "086536", "Address1", companyFinance));
        personList.add(new Person(2L, "Mircea", "045433", "Address2", companyFinance));
        personList.add(new Person(3L, "Iulian", "087436", "Address3", companyFinance));
        personList.add(new Person(4L, "Timmy", "087543", "Address4", companyFinance));
        personList.add(new Person(5L, "Claus", "086656", "Address5", companyFinance));
        personList.add(new Person(6L, "Mark", "0865345", "Address6", companyFinance));

        System.out.println(p2.count());
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
