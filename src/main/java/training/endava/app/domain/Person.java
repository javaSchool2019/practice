package training.endava.app.domain;

import java.util.Date;
import java.util.logging.Logger;

public class Person {

    private Integer id;
    private String name;
    private Date birthday;
    private String birthplace;

    public Person(Integer id, String name, Date birthday,String birthplace) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.birthplace = birthplace;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birthplace='" + birthplace + '\'' +
                '}';
    }


}
