package training.endava.playground.generics.types;

public class Bottle<T> extends Product implements Shippable<T> {
    private String producer;

    public void ship(T item) {
        System.out.println("Bottle was delivered");

    }

    public Bottle() {
    }

    public Bottle(String producer) {
        this.producer = producer;
    }

    public Bottle(String producer, Integer price) {
        super(price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "producer='" + producer + '\'' +
                '}';
    }
}
