package training.endava.skeleton;

import java.util.Objects;

public class Person implements SkeletonObject<Person, Integer> {
    private Company comp;
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;


    public Person(Integer id,String name, String phoneNumber,String address,Company comp){
        this.comp=comp;
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
    public String getAddress(){

        return address;
    }
    public Integer getId(){

        return id;
    }
    public String getName(){

        return this.name;
    }

    public String getPhoneNumber(){

        return this.phoneNumber;
    }

    public void setId(Integer id){
    this.id=id;
    }

    public void setName(String Name){
        this.name=Name;

    }
    public void setPhoneNumber(String PhoneNumber){
        this.phoneNumber=PhoneNumber;

    }
    public void setAddress(String Address){

        this.address=Address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", Address='" + address + '\'' +
                '}';
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
}
