package training.endava.playground.generics.types;

public class Fruit extends Product<Integer> implements Shippable{

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

    @Override
    public String toString() {
        return "Fruit{" +
                "calories='" + calories + '\'' +
                '}';
    }

    @Override
    public void ship(Object item) {
        System.out.println(item);
    }
}
