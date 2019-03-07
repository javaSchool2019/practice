package training.endava.playground.generics.types;

public class Box<T> {

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