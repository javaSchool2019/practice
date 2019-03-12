package training.endava.app.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

public class Person {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String adress;

    public Person() {
    }

    public Person(Integer id, String name, String phoneNumber, String adress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
