package training.endava.skeleton;

import training.endava.skeleton.Classes.Company;
import training.endava.skeleton.Classes.CompanyArea;
import training.endava.skeleton.Classes.Person;
import training.endava.skeleton.Classes.PersonRepository;
import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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
        Person p6 = new Person(6, "Cineva Marcel", "07576738483", "Bacau");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        Company company1 = new Company("Endava", 1999, CompanyArea.IT);
        Company company2 = new Company("Bitdefender", 1899, CompanyArea.IT);
        Company company3 = new Company("BCR", 1879, CompanyArea.FINANCE);
        Company company4 = new Company("Centric", 1879, CompanyArea.SUPPORT);

        List<Company> companies = new ArrayList<>();
        companies.addAll(Arrays.asList(company1,company2,company3,company4));
        company1.setPersonList(Arrays.asList(p1,p2,p4));
        company2.setPersonList(Arrays.asList(p3));
        company4.setPersonList(Arrays.asList(p5));
        company3.setPersonList(Arrays.asList(p6));

        /*
        //personList.forEach(System.out::println);

        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class, personList);
        //mockDB.getTable(Person.class).forEach(System.out::println);

        PersonRepository personRepository = new PersonRepository();
        System.out.println(personRepository.findById(1));

        personRepository.save(new Person(6, "Olariu Madalina", "07516738483", "Vaslui"));
        System.out.println(personRepository.findById(6));

        personRepository.findAll().forEach(System.out::println);
        */

        // 1
        List<String> companyNameList = companies.stream()
                .map(Company::getName)
                .collect(Collectors.toList());
        System.out.println(companyNameList);

        // 2
        companies.stream()
                .map(Company::getFoundationYear)
                .mapToInt(Integer::intValue)
                .sorted()
                .forEach(System.out::println);

        // 3
        Company oldest = companies.stream()
                .min((c1, c2) -> Integer.compare(c1.getFoundationYear(), c2.getFoundationYear()))
                .get();

        System.out.println(oldest);

        // 4
        int count = companies.stream()
                .map(Company::getPersonList)
                .map(List::size)
                .reduce(0,(s1,s2) -> s1+s2)
                .intValue();
        System.out.println(count);

        // 5
        Person p99 = companies.stream()
                .map(Company::getPersonList)
                .flatMap(List<Person>::stream)
                .reduce(new Person(), (per1, per2) -> {per1.setName(per1.getName() + per2.getName()); return per1;});


        // 6
        companies.stream()
                .map(Company::getPersonList)
                .flatMap(List<Person>::stream)
                .forEach(System.out::println);



        // 7
        List<Person> uniquePersonsByPhone = companies.stream()
                .map(Company::getPersonList)
                .flatMap(List<Person>::stream)
                .distinct()
                .collect(Collectors.toList());

        // 8

        Collector<Person, StringJoiner, String> nameConcatCollector =
                Collector.of(
                        () -> new StringJoiner("; ","Numbers: ",";"),
                        (supp, person) -> supp.add(person.getPhoneNumber()),
                        StringJoiner::merge,
                        StringJoiner::toString
                );
        String phoneNumbers = personList.stream().collect(nameConcatCollector);
        System.out.println(phoneNumbers);



        //9


        long startTime, endTime, duration;

        startTime = System.nanoTime();




        Integer sumOf1000Numbers = Stream.iterate(0, x -> x+2).limit(1000).reduce(0, (n1, n2) -> n1+n2).intValue();




        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("        Stream took " + duration + " nanoSec and the result is " + sumOf1000Numbers);

        startTime = System.nanoTime();
        sumOf1000Numbers = Stream.iterate(0, x -> x+2).limit(1000).parallel().reduce(0, (n1, n2) -> n1+n2).intValue();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("ParallelStream took " + duration + " nanoSec and the result is " + sumOf1000Numbers);

    }

}
