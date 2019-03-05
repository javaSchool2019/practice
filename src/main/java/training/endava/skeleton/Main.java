package training.endava.skeleton;
import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.List;
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



    }




}
