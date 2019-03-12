package training.endava.app.payload;

import training.endava.app.domain.Person;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDTO {
    @NotBlank
    private String name;
    @NotNull
    @Min(value = 0, message = "Age should not be less than 0")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Integer age;

    public PersonDTO(Long id, String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public PersonDTO() {}

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
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person toPerson (){
        return new Person(getName(), getAge());
    }

    public Person toPerson(long id){
        return new Person(id, getName(), getAge());
    }
}
