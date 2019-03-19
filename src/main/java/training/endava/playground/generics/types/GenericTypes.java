package training.endava.playground.generics.types;

import java.util.List;

public class GenericTypes {

    public static void main(String ... args) {
        Box<Bottle> box = new Box<>();
        box.packBox(new Bottle("Coca-cola"));

        Bottle cocaCola = box.emptyBox();
        System.out.println(cocaCola);

        // compiler checks

        Box<Fruit> box2 = new Box<>();
        box2.packBox(new Fruit(300));


        LimitedContainer<Fruit,Integer> container=new LimitedContainer<>(2);
        container.addContainer(new Fruit(100));
        container.addContainer(new Fruit(200));
        container.addContainer(new Fruit(300));

        System.out.println(container);

    }

    public static void printList(List<? super Fruit> listFruit) {
        listFruit.add(new Fruit(100));
        System.out.println(listFruit);

    }


}
