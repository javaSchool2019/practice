package training.endava.app.domain;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Person {
    @NotBlank
    private String name;
    @NonNull
    private Integer id;

    public Person(String nume, Integer id) {
        this.name = nume;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

}
