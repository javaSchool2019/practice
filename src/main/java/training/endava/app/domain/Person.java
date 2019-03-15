package training.endava.app.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Person {
    private Long id;
    private String name;
    private Date birthday;
    private String birthplace;
    private Address address;
    private List<PhoneNumber> phoneNumbers;

    public Person(Long id, String name, Date birthday, String birthplace, Address address, List<PhoneNumber> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) &&
                getName().equals(person.getName()) &&
                getBirthday().equals(person.getBirthday()) &&
                getBirthplace().equals(person.getBirthplace()) &&
                getAddress().equals(person.getAddress()) &&
                getPhoneNumbers().equals(person.getPhoneNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthday(), getBirthplace(), getAddress(), getPhoneNumbers());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", birthplace='" + birthplace + '\'' +
                ", address=" + address +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
