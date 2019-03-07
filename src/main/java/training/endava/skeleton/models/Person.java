package training.endava.skeleton.models;


import training.endava.skeleton.SkeletonObject;

public class Person implements SkeletonObject<Person, Integer> {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer integer) {
        this.id = integer;
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
        this.address = address;
    }

    public Person(Integer id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person [id: " + id + ",  name: " + name + ",  phone: " + phoneNumber + ",  address: " + address + "]";
    }

}
