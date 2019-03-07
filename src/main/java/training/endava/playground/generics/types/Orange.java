package training.endava.playground.generics.types;

public class Orange extends Fruit{
    private String type;

    public Orange(Integer calories, String type){
        super(calories);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
