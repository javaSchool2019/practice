package training.endava.skeleton;

import java.util.UUID;

public class Person implements SkeletonObject<Person, UUID> {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String address;

    public Person(UUID id, String name, String phoneNumber, String address){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID i) {
        id = i;
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

    @Override
    public String toString(){
        return "ID: " + id + ", name: " + name + ", phoneNumber: " + phoneNumber + ", address: " + address;
    }

    @Override
    public boolean equals(Object person){
        Person person1 = (Person) person;
        return phoneNumber.equals(person1.getPhoneNumber());
    }
}
