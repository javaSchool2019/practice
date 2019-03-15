package training.endava.app.domain;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Objects;

public class Person {
    @NonNull
    private Integer person_id;
    @NotBlank
    private String name;
    @NonNull
    private Date birthday;
    @NotBlank
    private String birthplace;
    @NonNull
    private Integer address_id;

    public Person(Integer person_id, @NotBlank String name, Date birthday, @NotBlank String birthplace, Integer address_id) {
        this.person_id = person_id;
        this.name = name;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person_id.equals(person.person_id);
    }

}
