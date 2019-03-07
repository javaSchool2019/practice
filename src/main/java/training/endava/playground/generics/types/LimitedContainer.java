package training.endava.playground.generics.types;

import training.endava.skeleton.Exceptions.IncorectRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class LimitedContainer<T, N extends Number> implements Shippable<T> {

    private List<T> contents;
    private N limit;

    public LimitedContainer(N limit){
        contents = new ArrayList<>();
        this.limit = limit;
    }

    public List<T> emptyContainer() {
        return contents;
    }

    public void packContainer(List<T> contents) {
        this.contents = contents;
    }

    public void addToContainer(T element){

        if(this.contents.size() < limit.intValue()){
            this.contents.add(element);
        }else{
            throw new IncorectRuntimeException("Container is already full");
        }
    }

    @Override
    public void ship(T item) {

    }
}
