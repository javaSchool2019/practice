package training.endava.skeleton;

import training.endava.skeleton.db.MockDB;
import training.endava.skeleton.model.Address;
import training.endava.skeleton.model.Person;
import training.endava.skeleton.model.PersonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {

        List<Person> persons=new ArrayList<>();
        Person p1=new Person(1,"Gigel1","07XXXXXXX1","Iasi");
        Person p2=new Person(2,"Gigel2","07XXXXXXX2","Botosani");
        Person p3=new Person(3,"Gigel3","07XXXXXXX3","Suceava");
        Person p4=new Person(4,"Gigel4","07XXXXXXX4","Tulcea");
        Person p5=new Person(5,"Gigel5","07XXXXXXX5","Galati");
        Person p6=new Person(6,"Gigel6","07XXXXXXX6","Brasov");
        Person p7=new Person(7,"Gigel7","07XXXXXXX7","Bacau");
        Person p8=new Person(8,"Gigel7","07XXXXXXX7","Bacau");

        persons.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

        System.out.println(persons);


        MockDB mockDB=MockDB.getInstance();
        mockDB.setTable(Person.class,persons);
//        System.out.println(mockDB.getTable(Person.class));



        //###################### PersonRepository ######################.

        PersonRepository pr=new PersonRepository(persons);

        System.out.println("-----------------------------------------------------------------------------------------");
        pr.save(p8);
        System.out.println(persons);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(pr.findById(8));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Person with id 8 exist in db: " + pr.existsById(8));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(pr.findAll());

        System.out.println("-----------------------------------------------------------------------------------------");
//        pr.deleteById(9);
//        System.out.println(persons);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Count: " + pr.count());

        System.out.println("-----------------------------------------------------------------------------------------");
        pr.deleteAll();
        System.out.println(persons);

    }


}
