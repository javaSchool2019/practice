package training.endava.playground.generics.types;

import java.util.List;

public class GenericTypes {

    public static void main(String ... args) {
        Box<Bottle> box = new Box<>();
        box.packBox(new Bottle("Coca-cola", 222.0));

        Bottle cocaCola = box.emptyBox();
        System.out.println(cocaCola);

        // compiler checks

        Box<Fruit> box2 = new Box<>();
        box2.packBox(new Fruit(300, 100));
        Fruit fruit = box2.emptyBox();
        System.out.println(fruit);

        LimitedContainer<Bottle, Integer> container = new LimitedContainer<>(2);
        container.addToContainer(new Bottle("Coca-Cola", 284.0));
        container.addToContainer(new Bottle("Sprite", 123.5));
        //container.addToContainer(new Bottle("Fanta", 89.5));
        // This throws an error because container limit

        //System.out.println(container.emptyContainer());
        printMyAmbigList(container.emptyContainer());
    }

    public static void printMyAmbigList(List<? super Bottle> list) {
        System.out.println(list);
    }
}
