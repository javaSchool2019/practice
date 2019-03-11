package training.endava.app.payload;

import training.endava.app.domain.Person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonPostDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer age;

    public PersonPostDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public PersonPostDTO() {}

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
    public String toString() {
        return "PersonPostDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person toPerson (){
        return new Person(getId(), getName(), getAge());
    }
}
