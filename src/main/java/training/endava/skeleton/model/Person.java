package training.endava.skeleton.model;

import java.time.Year;
import java.util.Objects;

public class Person implements SkeletonObject<Person, Long> {

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private Company company;

    public Person(Long id, String name, String phoneNumber, String address, Company company) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.company = company;
    }

    public Person(){
        this.name = "";
    }

    public Person(String name) {
        this.id = 0L;
        this.name = name;
        this.phoneNumber = "";
        this.address = "";
        this.company = new Company("Default", Year.of(200), Area.FINANCE);

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
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

    public Company getCompany() {
        return company;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\''+
                ", company=" + company.getName()
                ;
    }


}
