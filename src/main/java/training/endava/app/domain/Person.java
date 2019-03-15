package training.endava.app.domain;

import java.util.Objects;

public class Person {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Address address;
    private String birthday;
    private String birthplace;



    public Person(Integer id, String name, String email, String phone, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


    public Person(Integer id, String name, String email, String phone, Address address, String birthday, String birthplace) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.birthplace = birthplace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Person () {}


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birthplace='" + birthplace + '\'' +
                '}' + "\n";
    }
}
