package training.endava.playground.generics.types;

import java.util.ArrayList;
import java.util.List;

public class RoundBottle extends Bottle {

    private Integer capacity;

    public RoundBottle(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RoundBottle{" +
                "capacity=" + capacity +
                '}';
    }

    public static void addProduct(List<? super Bottle> list)
    {
        list.add(new RoundBottle(3) );
    }

    public static void main(String args[])
    {
        List<Product> p = new ArrayList<>();
        addProduct(p);

        System.out.println(p);
    }
}
