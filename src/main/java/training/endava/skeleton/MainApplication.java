package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;
import training.endava.skeleton.model.Company;
import training.endava.skeleton.model.CompanyArea;
import training.endava.skeleton.model.Person;
import training.endava.skeleton.model.PersonRepository;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainApplication {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        Person p1 = new Person(1, "Gigel1", "07XXXXXXX1", "Iasi");
        Person p2 = new Person(2, "Gigel2", "07XXXXXXX2", "Botosani");
        Person p3 = new Person(3, "Gigel3", "07XXXXXXX3", "Suceava");
        Person p4 = new Person(4, "Gigel4", "07XXXXXXX4", "Tulcea");
        Person p5 = new Person(5, "Gigel5", "07XXXXXXX5", "Galati");
        Person p6 = new Person(6, "Gigel6", "07XXXXXXX6", "Brasov");
        Person p7 = new Person(7, "Gigel7", "07XXXXXXX7", "Bacau");
        Person p8 = new Person(8, "Gigel8", "07XXXXXXX8", "Bucuresti");

        persons.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

//        System.out.println(persons);


        MockDB mockDB = MockDB.getInstance();
        mockDB.setTable(Person.class, persons);
//        System.out.println(mockDB.getTable(Person.class));


        //###################### PersonRepository DAY 3######################.

//        PersonRepository pr=new PersonRepository();
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        pr.save(p8);
//        System.out.println(persons);
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println(pr.findById(8));
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Person with id 8 exist in db: " + pr.existsById(8));
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println(pr.findAll());
//
//        System.out.println("-----------------------------------------------------------------------------------------");
////        pr.deleteById(9);
////        System.out.println(persons);
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Count: " + pr.count());
//
//        System.out.println("-----------------------------------------------------------------------------------------");
//        pr.deleteAll();
//        System.out.println(persons);


        //###################### Company DAY 5#########################.

        List<Person> persons1 = new ArrayList<>();
        Person p11 = new Person(1, "Gigel1", "07XXXXXXX1", "Iasi");
        Person p21 = new Person(2, "Gigel2", "07XXXXXXX2", "Botosani");
        Person p31 = new Person(3, "Gigel3", "07XXXXXXX3", "Suceava");

        persons1.addAll(Arrays.asList(p11, p21, p31));

        List<Person> persons2 = new ArrayList<>();
        Person p111 = new Person(1, "Gigel1", "07XXXXXXX1", "Iasi");
        Person p211 = new Person(2, "Gigel2", "07XXXXXXX1", "Botosani");
        Person p311 = new Person(3, "Gigel3", "07XXXXXXX1", "Suceava");

        persons1.addAll(Arrays.asList(p111, p211, p311));


        List<Company> companiesList = new ArrayList<>();
        Company c1 = new Company("Company 1", 2010, persons, CompanyArea.Finance, 1000000);
        Company c2 = new Company("Company 2", 2011, persons1, CompanyArea.CustomerSupport, 200000);
        Company c3 = new Company("Company 3", 2012, persons2, CompanyArea.It, 500000);

        companiesList.addAll(Arrays.asList(c1, c2, c3));




        System.out.println("******************************* 1 *********************************************");
        //1. List the names of all companies.

        List<String> namesOfAllCompanies = companiesList.stream()
                .map(Company :: getName)
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(namesOfAllCompanies);



        System.out.println("******************************* 2 *********************************************");
        // 2. Transform one of the object's property into a primitive stream and do some processing on it.

        companiesList.stream()
                .mapToDouble(Company::getProfit)
                .max()
                .ifPresent(System.out::println);



        System.out.println("************************* 3 ***************************************************");
        // 3. Find the oldest company based on the foundation year.

        Company oldestCompanyBasedOnFoundationYear = companiesList.stream()
                .min(Comparator.comparing(Company::getYear)).get();

//        System.out.println(oldestCompanyBasedOnFoundationYear);



        System.out.println("*************************** 4 *************************************************");
        //     4. Count the persons in the stream using map() and reduce().

        int nrOfPersons = companiesList.stream()
                .map(Company::getPersonList)
                .map(List::size)
                .reduce(0, (t1, t2) -> t1 + t2);

//        System.out.println(nrOfPersons);



        System.out.println("******************************* 5 *********************************************");
        //5. Use reduce() to create a Person instance that has the name created as a concatenation of all the other persons' names.

        Person personConcat=companiesList.stream()
                .map(Company::getPersonList)
                .flatMap(List::stream)
                .reduce(new Person( " "),(per1,per2)->{per1.setName(per1.getName()+per2.getName()); return per1;});

        System.out.println(personConcat);


        System.out.println("********************************** 6 ******************************************");
//        6. Transform a stream of companies in one of persons, in this way printing all the persons that are employed.

        List<Person> listOfPersons=companiesList.stream()
                .map(p -> p.getPersonList())
                .flatMap(List::stream)
                .collect(Collectors.toList());

//        System.out.println(listOfPersons);



        System.out.println("********************************* 7 *******************************************");
//        7. Display the unique persons using distinct(). Two persons are considered to be identical if they have the same phone number.

        List<Person> uniqueListOfPersons=companiesList.stream()
                .map(p->p.getPersonList())
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueListOfPersons);



        System.out.println("****************************** 8 **********************************************");
//        8. Implement a custom collector and print the results of applying it on a stream.

        Collector<Person, StringJoiner, String> customCollectorDefined=
                Collector.of(
                        ()->new StringJoiner(", " , "List of Persons: "," "),
                        (supp,person) ->supp.add(person.getName().toUpperCase()),
                        StringJoiner::merge,
                        StringJoiner::toString
                );
        String listNamesOfPersons=persons.stream().collect(customCollectorDefined);
        System.out.println(listNamesOfPersons);



        System.out.println("****************************** 9 **********************************************");
//        9. Create a big stream (at least 1000 elements). Use stream and parallelStream and some processing operations. Measure the results (e.g. "Stream took x seconds / ParallelStream took y seconds").

        List<Person> bigStream=new ArrayList<>();
        for (int i=0;i<=1010;i++){
            Person person=new Person(i, "Vasile", "075XXXXXX", "Address X");
            bigStream.add(person);
        }


        long startStream=System.nanoTime();
        bigStream.stream()
                .sorted(Comparator.comparing(Person::getId).reversed())
                .filter(i->i.getId()%2==0);
        long endStream=System.nanoTime();

        System.out.println("Stream: "  + (endStream-startStream));


        startStream=System.nanoTime();
        bigStream.parallelStream()
                .sorted(Comparator.comparing(Person::getId).reversed())
                .peek(System.out::println)
                .filter(i->i.getId()%2==0);
        endStream=System.nanoTime();

        System.out.println("Parallel Stream: "  + (endStream-startStream));

    }

}