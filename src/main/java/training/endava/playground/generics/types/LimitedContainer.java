package training.endava.playground.generics.types;
import java.util.*;
public class LimitedContainer<T, N extends Number> {
private List<T> list=new ArrayList<>();
private N restriction;

public LimitedContainer(N restriction){
    this.restriction=restriction;

}

public void copyInContainer(List<T> list){
    this.list=list;

}
public List<T> getContainer(){

    return this.list;
}

public void addElemInContainer(T elem){

    if(this.list.size()< this.restriction.intValue()){
        list.add(elem);
    }
    else {
        System.out.println("Max capacity");

    }
}

}
