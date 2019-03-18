package training.endava.playground.functionalinterfaces;

import java.util.function.Function;
import java.util.function.Supplier;

public class CustomFunctionalInterface {

    public static void main(String[] args) {
        print(() -> "Stefan");
        print(() -> "Stefan", (String name) -> "Mr. " + name);
    }

//    private static void print(NameSupplier nameSupplier) {
//        System.out.println("Hello" + nameSupplier.get());
//    }
//
//    private static void print(NameSupplier nameSupplier, NameDecorator nameDecorator) {
//        System.out.println("Hello " + nameDecorator.apply(nameSupplier.get()));
//    }

//    private static void print(NameSupplier nameSupplier) {
//        System.out.println("Hello" + nameSupplier.get());
//    }

    private static void print(Supplier<String> nameSupplier, Function<String, String> decorator) {
        System.out.println("Hello " + decorator.apply(nameSupplier.get()));
    }
//
    private static void print(Supplier<String> nameSupplier) {
        System.out.println("Hello " + nameSupplier.get());
    }

    private interface NameSupplier {
        String get();
    }

    private interface NameDecorator {
        String apply(String prefix);
    }
}
