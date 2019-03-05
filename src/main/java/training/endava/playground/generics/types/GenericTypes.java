package training.endava.playground.generics.types;
import java.util.*;
public class GenericTypes {

    public static void main(String ... args) {
        Box<Bottle> box = new Box<>();
        box.packBox(new Bottle("Coca-cola"));

        Bottle cocaCola = box.emptyBox();
        System.out.println(cocaCola);

        // compiler checks

        Box<Fruit> box2 = new Box<>();
        box2.packBox(new Fruit(300));


        Apple a =new Apple();
        List<? super Fruit> abc=new ArrayList();
        a.AddFruit(abc); // we can add children , but call function with a object of the class or a obj of a parent.


    }

}
