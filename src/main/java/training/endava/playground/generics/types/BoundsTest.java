package training.endava.playground.generics.types;

import java.util.ArrayList;
import java.util.List;

public class BoundsTest {

    public static void testMethod(List<? super Fruit> list) {
            list.add(new Apple(1));
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        testMethod(list);
        System.out.println(list);

//        List<Apple> list2 = new ArrayList<>();
//        testMethod(list2);
    }
}
