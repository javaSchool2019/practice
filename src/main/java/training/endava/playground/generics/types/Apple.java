package training.endava.playground.generics.types;

import java.util.*;

public class Apple extends Fruit {


   public void AddFruit(List<? super Fruit> a){
       Fruit abc =new Fruit();
       a.add(abc);
       Apple app =new Apple();
       a.add(app);


   }

}
