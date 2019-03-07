package training.endava.playground.generics.types;

import java.util.ArrayList;

public class LimitedContainer<T, N extends Number> {

    private ArrayList<T> contents;

    private N limit;

    public LimitedContainer(N limit)
    {
        contents = new ArrayList<>();
        this.limit = limit;
    }

    public void addContainer(T item)
    {
        if(this.contents.size() < (Integer) limit){
            this.contents.add(item);
        }else{
            System.out.println("You can't add another element. Container is already full");
        }
    }


}
