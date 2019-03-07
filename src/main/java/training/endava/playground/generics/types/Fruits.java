package training.endava.playground.generics.types;

import java.util.List;

public class Fruits {
    public static void printOrangeFruits(List<? super Fruit> orangeFruits){
        orangeFruits.add(new Orange(12, "Red"));
        System.out.println(orangeFruits);
    }
}
