package training.endava.playground.generics.types;

public class Product <T>{

    private T price;

    public Product() {}

    public Product(T price) {
        this.price = price;
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }
}
