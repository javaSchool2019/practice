package training.endava.skeleton.Classes;

import training.endava.skeleton.Exceptions.IncorectRuntimeException;
import training.endava.skeleton.Interfaces.SkeletonObject;

import java.util.ArrayList;
import java.util.List;

public class Person implements SkeletonObject<Person, Integer> {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String adress;

    public Person(Integer id, String name, String phoneNumber, String adress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
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
    public Integer getId() {
        return this.getId();
    }

    @Override
    public void setId(Integer integer) {
        this.id = integer;
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
