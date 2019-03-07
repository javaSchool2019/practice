package training.endava.playground.generics.types;

public class Bottle extends Product implements Shippable{

    private String producer;

    public Bottle() {}

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

    @Override
    public void ship(Object item) {
        System.out.println("This Bottle is shipped");
    }
}
