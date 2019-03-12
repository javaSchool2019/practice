package training.endava.app.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Person {

    private String forename;

    private String surname;

    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date birthday;

    public Person() {
    }

    public String getForename() {
        return forename;
    }

    public Person setForename(String forename) {
        this.forename = forename;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Person setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return forename.equals(person.forename) &&
                surname.equals(person.surname) &&
                birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forename, surname, birthday);
    }
}
