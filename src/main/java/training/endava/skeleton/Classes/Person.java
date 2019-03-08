package training.endava.skeleton.Classes;

import training.endava.skeleton.Exceptions.IncorectRuntimeException;
import training.endava.skeleton.Interfaces.SkeletonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Person implements SkeletonObject<Person, Integer> {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String adress;

    private Company company;

    public Person() {
    }

    public Person(Integer id, String name, String phoneNumber, String adress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }


    public Person(String name) {
        this.name = name;
        this.id = null;
        this.phoneNumber = null;
        this.company = null;
        this.adress = null;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        return this.id;
    }

    @Override
    public void setId(Integer integer) {
        this.id = integer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
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
