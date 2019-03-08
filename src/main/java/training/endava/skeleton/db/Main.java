package training.endava.skeleton.db;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String Args[])

    {
        Person test0 = new Person(1, "Andur", "0745", "Iasi");
        Person test1 = new Person(2, "Diana", "0746", "Vaslui");
        Person test2 = new Person(3, "Alina", "0747", "Suceava");
        Person test3 = new Person(4, "Ada", "0744", "Botosani");
        Person test4 = new Person(3, "Alina", "0747", "Suceava");
        Person test5 = new Person(4, "ASfas", "074412", "Iasi");

        //day1 exercises
        ArrayList<Person> mylist = new ArrayList<Person>();

        List<Company> companyList = new ArrayList<>();
        List<Person> personList1 = new ArrayList<>();

        //Company conti
        Company comp1 = new Company("Conti",1999,personList1,Company.compArea.IT);
        personList1.add(test0);
        personList1.add(test1);
        personList1.add(test2);

        companyList.add(comp1);

        //Company  Tast
        List<Person> personList2 = new ArrayList<>();
        Company comp2 = new Company("Tast",2000,personList2,Company.compArea.FINANCE);
        personList2.add(test3);
        personList2.add(test4);
        personList2.add(test5);

        companyList.add(comp2);

        List<String> companyesNameList = companyList.stream().map(company->company.getName()).collect(Collectors.toList());
        System.out.println(companyesNameList);

        int[] companySortYear = companyList.stream().
                map(Company::getfYear)
                .mapToInt(Integer::intValue).sorted().toArray();
        Arrays.stream(companySortYear).forEach(System.out::println);

        //ex 3
        Company oldestComp = companyList.stream().
                min(Comparator.comparingInt(Company::getfYear)).get();
        System.out.println(new StringBuilder().append("The oldest company: ").append(oldestComp).toString());

        //ex 4
        Integer countPersons = companyList.stream().
                map(Company::getListOfPers).
                map(List::size).
                reduce(0, (e1, e2) -> e1 + e2);
        System.out.println(countPersons);

        //6
        companyList.stream().map(a -> a.getListOfPers()).flatMap(Collection::stream).
                forEach(System.out::println);

        //7
        //unique persons using distinct()
        System.out.println( "---------" );
        companyList.stream().map(a -> a.getListOfPers()).flatMap(Collection::stream).distinct().
                forEach(System.out::println);

        //8 Implement a custom collector and print the results of applying it on a stream.
        Collector<Person, StringJoiner,String> coll =
                Collector.of(()->new StringJoiner(" , "," Prefix "," Suffix "),
                        (supp,person)->supp.add(person.getName().toUpperCase()),
                        StringJoiner::merge,
                        StringJoiner::toString);
        String names = companyList.stream().
                map(a -> a.getListOfPers()).flatMap(Collection::stream).collect(coll);
        System.out.println(names);


//        mylist.add(test0);
//        mylist.add(test1);
//        mylist.add(test2);
//        mylist.add(test3);
//
//        Print(mylist);

        MockDB db =  MockDB.getInstance();
        db.setTable(Person.class,mylist);

        ArrayList<Person> A =  (ArrayList)db.getTable(Person.class); //cast
        Print(A);

        Repo RepositoryCRUD = new  Repo();


        //RepositoryCRUD.save(test1);
        //RepositoryCRUD.deleteById(5);

    }
    public static void  Print (ArrayList <Person> listA){
        for(int i = 0;i< listA.size();i++)
        {
            System.out.println("ID: " + listA.get(i).getId());
            System.out.println("Nume: " + listA.get(i).getName());
            System.out.println("Phone Number: " + listA.get(i).getPhone_number());
            System.out.println("Adresa: " +listA.get(i).getAdress());

        }
    }
}
