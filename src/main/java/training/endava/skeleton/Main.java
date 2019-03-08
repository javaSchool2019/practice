package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;
import training.endava.playground.generics.types.Article;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void printArr(ArrayList<Person> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Name : " + " " + lista.get(i).getName());
            System.out.println("Id : " + " " + lista.get(i).getId());
            System.out.println("Phone Number : " + " " + lista.get(i).getPhoneNumber());
            System.out.println("Address : " + " " + lista.get(i).getAddress());


        }
    }

    public static void main(String args[]) {
        /*
    ArrayList<Person> PhoneBook=new ArrayList();

  Person pers1=new Person(1,"Hirtan Daniel","555-000-111", "Strada Arhitect Ioan nr. 16");

        PhoneBook.add(pers1);
        Person pers2=new Person(2,"Alex ABC","555-555-555", "Strada Pacurari nr. 123456");
        PhoneBook.add(pers2);
        Person pers3=new Person(3,"Victor ABC","555-585-888", "Strada Tatarasu nr. 12");
        PhoneBook.add(pers3);
        printArr(PhoneBook);


        MockDB db= MockDB.getInstance();
        db.setTable(Person.class,PhoneBook);

        ArrayList<Person> p1= (ArrayList)db.getTable(Person.class);
        printArr(p1);



        System.out.println("------------------------");


        PersonRepository PersRep=new PersonRepository();
        System.out.println(PersRep.existsById(1));

        System.out.println("------- SAVE:---------" );

        try{
            PersRep.save(new Person(4," Daniel","555-000-111", "Strada nr. 16"));

        }catch(ExceptiaMea e){
            System.out.println("Obiectul exista deja");

        }
        System.out.println("------- REMOVE---------" );
    try {
        PersRep.deleteById(9);
    }catch(ExceptiaMea e){System.out.println("Elementul nu exista");}

        System.out.println(PersRep.existsById(1));


        System.out.println("------- REMOVE ALL---------" );


       // PersRep.deleteAll();
       // System.out.println(PersRep.p1.get(0).getId());

       System.out.println(PersRep.findById(2));


        System.out.println("------- EXISTS ---------" );
       System.out.println( PersRep.existsById(4));


        System.out.println("------- SIZE ---------" );
        System.out.println( PersRep.count());




        List<Article> lista=new ArrayList<Article>();

        List<String> l1=new ArrayList<>();
        List<String> l2=new ArrayList<>();
        List<String> l3=new ArrayList<>();
        List<String> l4=new ArrayList<>();
        l1.add("tag1");
        l1.add("tag2");
        l1.add("tag3");
        l1.add("tag4");
        l2.add("tag8");
        l2.add("tag9");
        l2.add("tag9");
        l3.add("tag6");
        l3.add("tag9");
        l3.add("tag0");
        l4.add("tag150");



        Article articol1=new Article("Articol12",l1);
        Article articol2=new Article("Articol26",l2);
        Article articol3=new Article("Articol3",l3);
        Article articol4=new Article("Articol4",l4);

        lista.add(articol1);
        lista.add(articol2);
        lista.add(articol3);
        lista.add(articol4);
        Comparator<Article> com= new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getTitle().compareTo(o1.getTitle());
            }
        };
        lista.sort(com);

        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i).getTitle());
        }


        Set<String> tag=new HashSet<>();

        for(Article arti : lista){
            tag.addAll(arti.getTags());

        }
        System.out.println(tag);


    Map<Integer,List<Article>> m =new TreeMap<>();

    for(Article arti : lista){
        int nrTags= arti.getTags().size();

        if(m.containsKey(nrTags)){
            m.get(nrTags).add(arti);
        }
        else{
            m.put(nrTags,new ArrayList<>());
            m.get(nrTags).add(arti);
        }
    }

        for(Integer key : m.keySet()){
            System.out.println(key);
            System.out.println(m.get(key));

        }

*/

        List<Company> compList = new ArrayList<>();
        List<Person> persList = new ArrayList<>();
        Company comp1 = new Company("Company1", 1993, persList, CompanyArea.IT);
        Person pers1 = new Person(1, "Hirtan Daniel", "555-000-111", "Strada Arhitect Ioan nr. 16", comp1);
        persList.add(pers1);
        Person pers2 = new Person(2, "Alex ABC", "555-555-555", "Strada Pacurari nr. 123456", comp1);
        persList.add(pers2);
        Person pers3 = new Person(3, "Victor ABC", "555-585-888", "Strada Tatarasu nr. 12", comp1);
        persList.add(pers3);


        compList.add(comp1);

        List<Person> persList2 = new ArrayList<>();
        Company comp2 = new Company("Company2", 1990, persList2, CompanyArea.SUPPORT);

        Person pers4 = new Person(4, "ABC", "555-000888", "Strada nr. 16", comp2);
        persList.add(pers4);
        Person pers5 = new Person(5, " ABCDE", "555-999-555", "Strada Canta nr 123", comp2);
        persList.add(pers5);
        Person pers6 = new Person(6, "Victor ABC", "111-585-988", "Strada Colentina nr. 12", comp2);
        persList.add(pers6);

        compList.add(comp2);

        List<String> compNameList = compList.stream().
                map(Company::getName).collect(Collectors.toList());
        System.out.println(compNameList);

        int[] compSort = compList.stream().
                map(Company::getYear).
                mapToInt(Integer::intValue).sorted().toArray();

        for (int i = 0; i < compSort.length; i++)
            System.out.println(compSort[i]);


        Company oldestComp = compList.stream().
                min((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear())).get();

        System.out.println("Oldest person" + oldestComp.getName());


        Integer count = compList.stream().
                map(Company::getList).
                map(List::size).
                reduce(0, (e1, e2) -> e1 + e2).intValue();

        System.out.println(count);

        String name = compList.stream().
                map(x -> x.getList()
                        .stream().
                                map(y -> y.getName()).
                                reduce(" ", (a, b) -> a + b)).
                reduce(" ", (a, b) -> a + b);

        System.out.println("Nume concatenate :" + name);

        // display all persons working
        compList.stream().
                map(x -> x.getList()).flatMap(List<Person>::stream).forEach(System.out::println);

        //display all unique persons
        System.out.println("Distinct");
        compList.stream().map(x -> x.getList()).flatMap(List<Person>::stream).distinct().
                forEach(System.out::println);


        // Custom collector
        Collector<Person, StringJoiner, String> nameCollector = Collector.of(
                () -> new StringJoiner(", ", "Prefix", "Sufix"),
                (supp, person) -> supp.add(person.getName().toUpperCase()),
                StringJoiner::merge,
                StringJoiner::toString
        );
        String names = compList.stream().
                map(x -> x.getList()).flatMap(List<Person>::stream).collect(nameCollector);
        System.out.println(names);


        long startT,stopT,duration;
        startT=System.nanoTime();
        Integer sumStream= Stream.iterate(0, x->x+2).limit(1200).reduce(0,(a1,a2)->a1+a2).intValue();

        stopT=System.nanoTime();
        duration=stopT-startT;
        System.out.println("Duration: " + duration);





        long startTParallel,stopTParallel,durationParallel;
        startTParallel=System.nanoTime();
        Integer sumStreamParallel= Stream.iterate(0, x->x+2).limit(1200).parallel().reduce(0,(a1,a2)->a1+a2).intValue();

        stopTParallel=System.nanoTime();
        durationParallel=stopTParallel-startTParallel;
        System.out.println("Duration Parallel: " + durationParallel);


    }


}
