package training.endava.playground.generics.types;

public class Fruit implements Shippable<Fruit>{

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
    public void ship(Fruit item) {
        System.out.println("this is the shipped item");
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "calories=" + calories +
                '}';
    }
}
