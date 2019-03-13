package training.endava.playground.functionalinterfaces;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        final int[] myIntegers = {1, 2, 7, 10, 20};
        Supplier<Integer> integerSupplier = () -> new Random().nextInt(20);
        Supplier<Integer> mySupplier = () -> myIntegers[new Random().nextInt(myIntegers.length)];

        for (int i=0; i<10; i++) {
            print(integerSupplier);
        }
        System.out.println("#####");
        for (int i=0; i<10; i++) {
            print(mySupplier);
        }

    }

    private static void print(Supplier<Integer> nameSupplier) {
        System.out.println(nameSupplier.get());
    }
}
