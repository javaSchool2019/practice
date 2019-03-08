package training.endava.playground.generics.types;

import java.awt.font.NumericShaper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LimitedContainer<T, N extends Number> implements Comparator<Number> {

    private List<T> contents;

    private N limit;

    public LimitedContainer(N limit)
    {
        contents = new ArrayList<>();
        this.limit = limit;
    }

    @Override
    public int compare(Number sizeOfContents, Number counter) {
        return new BigDecimal(sizeOfContents.toString()).compareTo(new BigDecimal(counter.toString()));
    }

    public void addContainer(T item, Number limit)
    {
        if(compare(contents.size(), limit)>1){
            contents.add(item);
        }else{
            System.out.println("You can't add another element. Container is already full");
        }
    }


}
