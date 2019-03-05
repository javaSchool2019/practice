package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;
import training.endava.playground.generics.types.Article;

import java.sql.SQLOutput;
import java.util.*;
public class Main {

    public static void printArr(ArrayList<Person> lista){
        for(int i=0;i<lista.size();i++) {
            System.out.println("Name : " + " "+ lista.get(i).getName());
            System.out.println("Id : " + " " + lista.get(i).getId());
            System.out.println("Phone Number : " + " " + lista.get(i).getPhoneNumber());
            System.out.println("Address : " + " "+ lista.get(i).getAddress());


        }
    }

    public static void main(String args[]){
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


        */

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




    }





}
