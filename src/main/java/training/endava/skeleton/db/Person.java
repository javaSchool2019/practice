package training.endava.skeleton.db;

import training.endava.skeleton.SkeletonObject;

public class Person implements SkeletonObject<Person, Integer> {

    private String name;
    private Integer ID;
    private String phoneNumber;
    private String Address;


    public Person(String name, Integer ID, String phoneNumber, String address) {
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        Address = address;
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
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public Integer getId() {
        return ID;
    }

    @Override
    public void setId(Integer id) {
        this.ID = id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
