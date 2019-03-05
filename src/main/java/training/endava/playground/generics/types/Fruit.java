package training.endava.playground.generics.types;

public class Fruit implements Shippable{
    private String name;
    private Integer calories;

   public void ship(Object item){
       System.out.println("Delivered");

    }

    public String getName() {
        return name;
    }

    public Fruit(){}
    public Fruit(String name){
        this.name=name;

    }
    public Fruit(Integer calories) {
        this.calories = calories;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
