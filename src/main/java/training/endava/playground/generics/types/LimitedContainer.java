package training.endava.playground.generics.types;

import java.util.ArrayList;
import java.util.List;

public class LimitedContainer<T, N extends Number> {

    private List<T> objects;
    private N limit;

    public LimitedContainer(N limit) {
        this.limit = limit;
        this.objects = new ArrayList<>();
    }

    public void add(T obj) {
        if (objects.size() < limit.intValue()) {
            objects.add(obj);
        } else throw new UnsupportedOperationException("Container is full");
    }

    public void remove(T obj) {
        if (objects.contains(obj)) {
            objects.remove(obj);
        } else throw new UnsupportedOperationException("Object " + obj + " not found");
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public N getLimit() {
        return limit;
    }

    public void setLimit(N limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "LimitedContainer{" +
                "objects=" + objects +
                ", limit=" + limit +
                '}';
    }
}
