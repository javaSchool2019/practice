package training.endava.playground.functionalinterfaces;

@FunctionalInterface
interface Adder {
    int add(int a, int b);
    default int addTwoIntegers() {
        return 1+2;
    }
}

// is this a functional interface?
@FunctionalInterface
interface SmartAdder extends Adder {
    static int add(double a, double b) {
        return 1;
    }
}

class ExperimentInheritance {
    Adder adder = (a, b) -> a + b;
//    SmartAdder adder1 = (Integer a, Integer b) -> a + b;
}