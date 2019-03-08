package training.endava.playground.generics.types;

public class Fruit implements Shippable {

    private Integer calories;

    public Fruit(Integer calories) {
        this.calories = calories;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    public void ship(Object obj)
    {
        System.out.println( "Works with object parameter! ");
    }
}
