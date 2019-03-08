package training.endava.skeleton.db;
import training.endava.skeleton.SkeletonObject;

import java.util.Objects;

public class Person implements SkeletonObject<Person,Integer>{

    //private Company company;
    public Integer getId;
    private Integer ID;
    private String name;
    private String phone_number;
    private String adress;

    public Person(Integer ID, String name, String phone_number, String adress) {
        this.ID = ID;
        this.name = name;
        this.phone_number = phone_number;
        this.adress = adress;
    }

    public Integer getId()
    {
        return ID;
    }

    public void setId(Integer id)
    {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "getId=" + getId +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(phone_number, person.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone_number);
    }
}
