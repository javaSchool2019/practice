package training.endava.app.domain;

import java.util.logging.Logger;

public class Person {

    private Integer id;
    private String name;
    private String prenume;

    public Person(Integer id, String name, String prenume) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
