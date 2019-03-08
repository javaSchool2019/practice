package training.endava.skeleton;

import java.util.Comparator;
import java.util.Objects;

public class Person implements SkeletonObject<Person, Integer> {

    private String name;
    private Integer id;
    private String phoneNumber;
    private String address;
    private Company company;

    public Person()
    {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name, Integer id, String phoneNumber, String address, Company company) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.company = company;
    }

    public Person(String name, Integer id, String phoneNumber, String address) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ID=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber.equals(person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
