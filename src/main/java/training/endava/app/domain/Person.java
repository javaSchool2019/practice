package training.endava.app.domain;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Person {
    private Long id;
    private String name;
    private Integer age;

    public Person(@NotBlank Long id, @NotBlank String name, @NotBlank Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Person(Long id){
        this.id = id;
    }

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) &&
                getName().equals(person.getName()) &&
                getAge().equals(person.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
