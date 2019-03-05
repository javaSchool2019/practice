package training.endava.playground.generics.types;

public class Box<T> implements Shippable<Box>{

    public void ship(Box item){
            System.out.println("Box was delivered");

    }
    private T contents;

    public T emptyBox() {
        return contents;
    }

    public void packBox(T contents) {
        this.contents = contents;
    }

    public void createContents() {
//        contents = new T();
    }
}