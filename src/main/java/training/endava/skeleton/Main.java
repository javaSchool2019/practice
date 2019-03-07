package training.endava.skeleton;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String argv[]) {
        //save and restore skeletonObject list
//        List<Person> list = new ArrayList<Person>();
//        MockDB db = MockDB.getInstance();
//        db.setTable(Person.class, makeList());
//        list = (ArrayList) db.getTable(Person.class);
//        prettyPrint(list);

        //crud operations
//        SkeletonRepository<Person, Integer> model = new Model();

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
//        System.out.println(model.findById(1));
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
    }

    public static ArrayList<Person> makeList() {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 3; i++) {
            Person p = new Person("name" + i, "emailAddress" + i, i * 5 * 6 * 3 + "0", i);
            list.add(p);
        }
        return list;
    }

    public static void prettyPrint(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
