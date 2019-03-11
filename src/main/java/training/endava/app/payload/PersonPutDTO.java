package training.endava.app.payload;

import training.endava.app.domain.Person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonPutDTO {
    @NotBlank
    private String name;
    @NotNull
    private Integer age;

    public PersonPutDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public PersonPutDTO() {
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
    public String toString() {
        return "PersonPostDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person toPerson(long id) {
        return new Person(id, getName(), getAge());
    }
}
