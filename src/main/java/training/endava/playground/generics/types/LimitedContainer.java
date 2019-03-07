package training.endava.playground.generics.types;

import java.util.LinkedList;
import java.util.List;

public class LimitedContainer<T, N extends Number> {
    private LinkedList<Box<T>> container;
    private N limit;

    public LimitedContainer(List<Box<T>> container, N limit){
        if (container.size() > limit.intValue())
            this.container = new LinkedList<>(container.subList(container.size() - 1 - limit.intValue(), container.size() - 1));
        this.container = new LinkedList<>(container);
        this.limit = limit;
    }

    public void add(Box<T> box){
        container.pop();
        container.add(box);
    }

    @Override
    public String toString() {
        return "Limit: " + limit + "---- Container: " + container;
    }
}
