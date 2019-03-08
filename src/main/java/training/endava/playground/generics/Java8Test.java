package training.endava.playground.generics;

import java.util.stream.Stream;

public class Java8Test {

    public static void main(String[] args) {
        System.out.println( Stream.iterate(1, n ->n+2).allMatch(i -> i%2 ==0));
    }
}
