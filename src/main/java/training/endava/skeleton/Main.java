package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Main {

    public static void main(String args[]){

        Person p1 = new Person("Ana01", 1, "0701", "Iasi01");
        Person p2 = new Person("Ana02", 2, "0702", "Iasi02");
        Person p3 = new Person("Ana03", 3, "0703", "Iasi03");
        Person p4 = new Person("Ana04", 4, "0704", "Iasi04");
        Person p5 = new Person("Ana05", 5, "0705", "Iasi05");
        Person p6 = new Person("Ana06", 6, "0706", "Iasi06");

        List<Person> personList = new ArrayList<>();
        List<Person> personList2 = new ArrayList<>();
        List<Person> personList3 = new ArrayList<>();

        personList.add(p1);
        personList.add(p2);

        personList2.add(p3);
        personList2.add(p4);

        personList3.add(p5);
        personList3.add(p6);


        //System.out.println("LIST 1:");
        //System.out.println(personList);

        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class, personList);

        //System.out.println("LIST 2:");
        //System.out.println(mockDB.getTable(Person.class));

        PersonRepository personRepository = new PersonRepository();

        personRepository.save(new Person("Ana09", 10, "0706", "Iasi06") );
        personRepository.findById(10);

        //System.out.println(personRepository.existsById(10));

        Company fisrtCompany = new Company("C01", 1987,personList, 100,CompanyArea.IT);
        Company secondCompany = new Company("C02", 2014,personList2,200,CompanyArea.QA);
        Company thirdCompany = new Company("C03", 1875,personList3,300,CompanyArea.FINANCE);

        List<Company> companyList = new ArrayList<>();
        companyList.add(fisrtCompany);
        companyList.add(secondCompany);
        companyList.add(thirdCompany);

        List<String> names = companyList.stream()
                .map(Company::getName)
                .collect(Collectors.toList());
        //System.out.println(names);

        int maxCapacity = companyList.stream()
                .mapToInt(Company::getCompanyCapacity)
                .max()
                .getAsInt();

        //System.out.println(maxCapacity);

        Company oldestCompany = companyList.stream()
                .max((c1, c2) -> Integer.compare(c1.getFoundationYear(),(c2.getFoundationYear())))
                .get();

        //System.out.println(oldestCompany);

        int count = companyList.stream()
                .map(Company::getPersons)
                .map(List::size)
                .reduce(0,(pers1 , pers2) -> pers1 + pers2);

        //System.out.println(count);

        //System.out.println(nameConcatenation);

        Person nameConcatenation = companyList.stream()
                .map(Company::getPersons)
                .flatMap(List::stream)
                .reduce(new Person(" "), (per1, per2) -> {per1.setName(per1.getName() + per2.getName()); return per1;});

        companyList.stream()
                .map(Company::getPersons)
                .flatMap(List::stream)
                .forEach(System.out::print);

        //Display the unique persons using distinct(). Two persons are considered to be identical if they have the same
        // phone number.
        companyList.stream()
                .map(Company::getPersons)
                .flatMap(List<Person>::stream)
                .distinct()
                .collect(Collectors.toList());

        //Implement a custom collector and print the results of applying it on a stream.
        Collector<Company, StringJoiner, String> namesCollector =
            Collector.of(
                    ()-> new StringJoiner(",", "Start ", " End"),
                    (supp, company) -> supp.add(company.getName().toUpperCase()),
                    StringJoiner::merge,
                    StringJoiner::toString
            );

        String namesofCompanies = companyList.stream().collect(namesCollector);
        //System.out.println(namesofCompanies);

        List<Person> bigList = new ArrayList<>();
        for(int i=0; i< 1003 ; i++)
        {
            Person p = new Person("Ana" + i, i + 100);
            bigList.add(p);
        }

        long startStream = System.nanoTime();

        bigList.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .filter(i-> i.getId()% 2 ==0)
                .forEach(System.out::println);

        long endStream = System.nanoTime();


        long startParallelStream = System.nanoTime();

        bigList.parallelStream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .filter(i-> i.getId()% 2 ==0)
                .forEach(System.out::println);

        long endParallelStream = System.nanoTime();

        System.out.println("\nTime Stream: " + (endStream - startStream));
        System.out.println("Time Parallel Stream:" + (endParallelStream - startParallelStream));
    }
}
