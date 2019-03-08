package training.endava.playground.generics.types;

import java.util.ArrayList;

public class YellowFruits {

    public YellowFruits() {

        ArrayList<Product> list = new ArrayList<>();
        Banana b = new Banana(1);
        Fruit f = new Fruit(1);
        Product p = new Product();
        list.add(f);
        list.add(b);
        list.add(p);

        makeList(list);

        ArrayList<Banana> list2 = new ArrayList<>();
//        list2.add(f);
        list2.add(b);
//        list2.add(p);
//        makeList(list2);
    }
    public void makeList(ArrayList<? super Fruit> list){
        list.add(new Fruit(1));
    }
}

