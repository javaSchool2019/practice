package training.endava.playground.generics.types;

public class Product<N> {

    private N price;

    public Product() {}

    public Product(N price) {
        this.price = price;
    }

    public N getPrice() {
        return price;
    }

    public void setPrice(N price) {
        this.price = price;
    }
}
