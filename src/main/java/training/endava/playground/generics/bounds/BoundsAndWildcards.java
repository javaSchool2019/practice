package training.endava.playground.generics.bounds;

import training.endava.playground.generics.types.Article;
import training.endava.playground.generics.types.Product;

import java.util.ArrayList;
import java.util.List;

public class BoundsAndWildcards {

    public static void main(String ... args) {
        BoundsAndWildcards boundsAndWildcards = new BoundsAndWildcards();
        boundsAndWildcards.addNumbers(new ArrayList<Number>());
    }

    public double sumOfList(List<? extends Number> list) {
        //it works on List<Integer>, List<Double>, List<Number>, etc.
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
    }

    public void addNumbers(List<? super Integer> list) {
        //it works on List<Integer>, List<Number>, and List<Object> —
        //anything that can hold Integer values.
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

}
