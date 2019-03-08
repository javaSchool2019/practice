package training.endava.playground.generics.types;

import training.endava.skeleton.db.ExceptionLimitedContainer;

import java.util.*;

public class LimitedContainer<T, N extends Number>  {

    private List<T> l;
    private N limit;

    public LimitedContainer(N limit){
        l = new ArrayList<>();
        this.limit = limit;
    }

    public List<T> emptyContainer() {
        return l;
    }

    public void packContainer(List<T> l)
    {
        this.l = l;
    }

    public void addInContainer(T element){

        if(this.l.size() < limit.intValue()){
            this.l.add(element);
        }else{
            throw new ExceptionLimitedContainer("Container is already full");
        }
    }
}
