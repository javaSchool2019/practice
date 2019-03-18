package training.endava.playground.functionalinterfaces;

public class Legacy {

    public static class PrintingRunnable implements Runnable{
        public void run() {
            System.out.println("runnable implementing class thread running");
        }
    }

    public static void main(String ... args) {
        Thread t1 = new Thread(new PrintingRunnable());
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("lambda thread running");
        });
        t2.start();
    }
}
