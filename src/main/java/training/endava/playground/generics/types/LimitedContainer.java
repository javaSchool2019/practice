package training.endava.playground.generics.types;

import java.util.List;

public class LimitedContainer<T, N> {

    private Integer size;
    private List<T> cachingList;

    public Integer getSize() {
        return size;
    }

    public List<T> getCachingList() {
        return cachingList;
    }

    public LimitedContainer(N size, List<T> cachingList) {
        this.size = (Integer) size;
        this.cachingList = cachingList;
    }

    public void add (T element){
        if(this.cachingList.size() >= size){
            throw new RuntimeException("The container is full");
        }
        this.cachingList.add(element);

    }

    public boolean delete (T element){
        return this.cachingList.remove(element);
    }
}
