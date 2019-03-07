package training.endava.skeleton.db;

import java.util.ArrayList;
public class Main {

    public static void main(String Args[])

    {
        Person test0 = new Person(1, "Andur", "0745", "Iasi");
        Person test1 = new Person(2, "Diana", "0746", "Vaslui");
        Person test2 = new Person(3, "Alina", "0747", "Suceava");
        Person test3 = new Person(4, "Ada", "0744", "Botosani");

        ArrayList<Person> mylist = new ArrayList<Person>();

        mylist.add(test0);
        mylist.add(test1);
        mylist.add(test2);
        mylist.add(test3);

        Print(mylist);

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
