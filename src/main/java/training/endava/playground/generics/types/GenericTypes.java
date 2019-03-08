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

        LimitedContainer<Fruit, Integer> limitedContainer = new LimitedContainer<>(1);
        //limitedContainer.addContainer(new Fruit(3));
       // limitedContainer.addContainer(new Fruit(5));
      //  limitedContainer.addContainer(new Fruit(4));

        System.out.println(limitedContainer);

    }



}
