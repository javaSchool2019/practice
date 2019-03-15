package training.endava.app.domain;

import java.time.LocalDate;

public class Person {

    private long id;
    private String name;
    private LocalDate birthdate;
    private String birthplace;
    private long address_id;

    public Person() {

    }

    public Person(long id, String name, LocalDate birthdate, String birthplace, long address_id) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.address_id = address_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;    
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public long getAddress() {
        return address_id;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return id == person.getId() && name.equals(person.getName());
    }

    @Override
    public String toString() {
        return "Person{ " + "id = " + id + ", name = " + name + ", birthdate = " + birthdate + ", birthplace = " + birthplace +
                "address_id = " + address_id + "}";
    }
}
