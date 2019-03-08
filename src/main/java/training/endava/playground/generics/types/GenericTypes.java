package training.endava.playground.generics.types;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {

    public static void main(String... args) {
        Box<Bottle> box = new Box<>();
        box.packBox(new Bottle("Coca-cola", 22.50));

        Bottle cocaCola = box.emptyBox();
        System.out.println(cocaCola);

        Box<Fruit> box2 = new Box<>();
        box2.packBox(new Fruit(300, 5));

        Fruit fruit = box2.emptyBox();
        System.out.println(fruit);

        LimitedContainer<Product, Double> container = new LimitedContainer<>(3.2);
        container.add(cocaCola);
        container.add(fruit);
        container.add(new Fruit(150, 10));
        try {
            container.add(new Bottle("Sprite", 10.5));
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            container.remove(new Bottle("Sprite", 10.5));
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(container);


        testUpperBoundForFruits(new ArrayList<Product>());  // Ok (super class)
        testUpperBoundForFruits(new ArrayList<Fruit>());  // Ok (same class)
        // testUpperBoundForFruits(new ArrayList<Bottle>());  //  Compile error (other type)
        // testUpperBoundForFruits(new ArrayList<RomanianFruit>());  //  Compile error (sub class)
    }

    public static void testUpperBoundForFruits(List<? super Fruit> products) {
        products.add(new Fruit(100, 10));
        System.out.println(products);
    }
}
