package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;

import java.time.Year;
import java.util.*;
import java.util.stream.Collector;

public class Main {
    public static void main(String argv[]) {
        //save and restore skeletonObject list
//        List<Person> list = new ArrayList<Person>();
//        MockDB db = MockDB.getInstance();
//        Company comp = new Company("test",list,Company.Departments.IT,Year.of(14));
//        db.setTable(Person.class, makeList(comp,new Random().nextInt(5)));
//        list = (ArrayList) db.getTable(Person.class);
//        prettyPrint(list);

        //crud operations
        SkeletonRepository<Person, Integer> model = new Model();

        //count
//        System.out.println(model.count());

        //save
//        prettyPrint(model.findAll());
//        Person p=null;
//        model.save(p);
//        p = new Person("nume", "email", "1234", 123);
//        model.save(p);
//        model.save(p);
//        prettyPrint(model.findAll());

        //findById
//        System.out.println(model.findById(1).orElse(new Person("new","email","tel2",555,comp)));
//        System.out.println(model.findById(10));

        //existsById
//        System.out.println(model.existsById(1));
//        System.out.println(model.existsById(10));

        //findAll
//        prettyPrint(model.findAll());

        //deleteById
//        System.out.println(model.findById(1));
//        model.deleteById(1);
//        System.out.println(model.findById(1));

        //deleteAll
//        prettyPrint(model.findAll());
//        model.deleteAll();
//        prettyPrint(model.findAll());

        //collections exercises
//        Exercises first = new Exercises();
//        first.sortByTitle();
//        first.printUniqueTitles();
//        first.printGroupByNrOfTags();

        //Generics demo for lower-bound
//        YellowFruits y = new YellowFruits();
        ArrayList<Company> companies = (ArrayList<Company>) makeCompanies(Optional.empty());
        companies = (ArrayList<Company>) populateCompanies(companies);

        //Stream Exercises
        //ex 1
        companies.stream().forEach(System.out::println);

        //ex2
        //in person implementation (setId)

        //ex3
//        System.out.println(companies.stream().min((a,b)-> a.getFoundationYear().compareTo(b.getFoundationYear())).get().getName());

        //ex4
//        System.out.println(companies.stream().map(x -> x.getEmployeeList().size()).reduce(0,(a,b)->a+b));

        //ex5
//        String name = companies.stream()
//                .map(x -> x.getEmployeeList()
//                        .stream()
//                        .map(y -> y.getName())
//                        .reduce("", (a, b) -> a + b))
//                .reduce("", (a, b) -> a + b);
//        System.out.println(new Person(name, "email", "tel", 123456, companies.get(3)));

        //ex6
//        companies.stream().
//                forEach(x -> x.getEmployeeList()
//                        .stream()
//                        .map(y -> y.getName())
//                .forEach(System.out::println));
        //ex7
//        companies.stream()
//                .forEach(x -> x.getEmployeeList()
//                        .stream()
//                        .map(y -> y.getPhoneNumber())
//                        .forEach(System.out::println));
//        System.out.println("distinct ----------------------------");
//        companies.stream()
//                .forEach(x -> x.getEmployeeList()
//                        .stream()
//                        .map(y -> y.getPhoneNumber())
//                        .distinct()
//                        .forEach(System.out::println));
        //ex8
//        Collector<Person, StringJoiner, String> collector =
//                Collector.of(
//                        () -> new StringJoiner("//", "Toate: ", " persoanele"),
//                        (supp, person) -> supp.add(person.getName()),
//                        StringJoiner::merge,
//                        StringJoiner::toString
//                );
//        Optional<String> name = companies.stream()
//                .map(x -> x.getEmployeeList()
//                        .stream()
//                        .collect(collector))
//                .findFirst();
//        System.out.println(name.get());

        //ex9
//        Optional<Integer> upperBound = Optional.of(new Integer(1000));
//        ArrayList<Company> companies2 = (ArrayList<Company>) makeCompanies(upperBound);
//        companies2 = (ArrayList<Company>) populateCompanies(companies2);
//
//        Long streamStart = System.nanoTime();
//
//        companies2.stream()
//                .forEach(x -> x.getEmployeeList()
//                        .stream()
//                        .map(y -> y.getPhoneNumber())
//                        .reduce("",(a,b)->a+b));
//
//        System.out.println("Stream took ms:" + (System.nanoTime() - streamStart)/10000000);
//        Long ParallelStreamStart = System.nanoTime();
//
//        companies2.parallelStream()
//                .forEach(x -> x.getEmployeeList()
//                        .stream()
//                        .map(y -> y.getPhoneNumber())
//                        .reduce("",(a,b)->a+b));
//        System.out.println("ParallelStream took ms:" + (System.nanoTime() - streamStart)/10000000);

    }

    public static List<Company> makeCompanies( Optional<Integer> bound) {
        Integer upperBound = 6;
        if(bound.isPresent()){
            upperBound = bound.get();
        }
        ArrayList<Company> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Company company = new Company("company" + i, new ArrayList<Person>(), Company.Departments.FINANCE, Year.of(i));
            list.add(company);
        }
        for (int i = 3; i < upperBound; i++) {
            Company company = new Company("company" + i, new ArrayList<Person>(), Company.Departments.IT, Year.of(i));
            list.add(company);
        }
        return list;
    }

    public static List<Person> makeList(Company company, Integer phone) {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            int rand = random.nextInt(1000);
            Person p = new Person("name" + rand, "emailAddress" + rand, phone + "0", rand, company);
            list.add(p);
        }
        return list;
    }

    public static List<Company> populateCompanies(ArrayList<Company> list) {
        Random rand = new Random();
        for (Company c :
                list) {
            ArrayList<Person> employee = (ArrayList<Person>) makeList(c, rand.nextInt(4));
            for (Person p :
                    employee) {
                c.addEmployee(p);
            }
        }
        return list;
    }

    public static void prettyPrint(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
