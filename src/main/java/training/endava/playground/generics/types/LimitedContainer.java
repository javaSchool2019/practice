package training.endava.playground.generics.types;

import java.util.ArrayList;

public class LimitedContainer<T, N extends Number> {
    ArrayList<T> container = new ArrayList<T>();
    N limit;

    public LimitedContainer(Class<T> c, N nr) {
        this.limit = nr;
    }

    public boolean add(T obj) {
        if (this.container.size() < (Integer) this.limit) {
            this.container.add(obj);
            return true;
        }
        return false;
    }
}
