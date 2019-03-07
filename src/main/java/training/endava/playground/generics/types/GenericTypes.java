package training.endava.playground.generics.types;

public class GenericTypes {

    public static void main(String ... args) {
        Box<Bottle> box = new Box<>();
        box.packBox(new Bottle("Coca-cola"));

        Bottle cocaCola = box.emptyBox();
        System.out.println(cocaCola);

        // compiler checks

        Box<Fruit> box2 = new Box<>();
        box2.packBox(new Fruit(300));


    }

}
