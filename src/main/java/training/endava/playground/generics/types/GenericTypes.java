package training.endava.playground.generics.types;

import java.util.ArrayList;
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

        Box<Fruit> box3 = new Box<>();
        box3.packBox(new Fruit(400));

        Box<Fruit> box4 = new Box<>();
        box4.packBox(new Fruit(500));

        List<Box<Fruit>> boxes = new ArrayList<>();
        boxes.add(box2);
        boxes.add(box3);
        LimitedContainer<Fruit, Integer> limitedContainer = new LimitedContainer<>(boxes, 2);
        System.out.println(limitedContainer);

        LimitedContainer<Fruit, Double> limitedContainerDouble = new LimitedContainer<>(boxes, 2.2);
        System.out.println(limitedContainerDouble);
        limitedContainer.add(box4);
        System.out.println(limitedContainer);

        List<Fruit> fruits = new ArrayList<>();
        Fruits.printOrangeFruits(fruits);

        List<Orange> products = new ArrayList<>();
//        Compile Error
//        Fruits.printOrangeFruits(products);

    }

}
