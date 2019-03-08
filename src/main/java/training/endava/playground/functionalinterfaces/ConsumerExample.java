package training.endava.playground.functionalinterfaces;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String ... args) {
        Consumer<String> consumer = System.out::println;

        consumer.accept("Stefan");
    }
}
