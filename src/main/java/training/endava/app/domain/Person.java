package training.endava.app.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Person {

    private Integer id;

    private String name;

    private String prenume;

    private Integer adressId;

    private Date birthday;

    public Person(Integer id, String name, String prenume, Integer adressId, Date birthday) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.adressId = adressId;
        this.birthday = birthday;
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

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adressId=" + adressId +
                ", birthday=" + birthday +
                '}';
    }
}
