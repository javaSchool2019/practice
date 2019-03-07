package training.endava.playground.generics.types;

import java.util.ArrayList;
import java.util.List;

public class LimitedContainer<T, N extends Number> {

private N maxim;
private List<T> contents;

    public LimitedContainer(N maxim) {
        contents = new ArrayList<>();
        this.maxim = maxim;
    }

    public void addContainer(T item){
        if (this.contents.size()<maxim.intValue()){
            this.contents.add(item);
        }
        else {
            System.out.println("You can not add more itmes to container!");
        }
    }

    @Override
    public String toString() {
        return "LimitedContainer{" +
                "maxim=" + maxim +
                ", contents=" + contents +
                '}';
    }
}


