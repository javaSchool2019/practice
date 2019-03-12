package training.endava.app.domain;

public class Person {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return id == person.getId() && name.equals(person.getName());
    }
}