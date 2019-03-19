package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")

public class Person {

    @Id
    @Column (name = "pId")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column (name = "pName")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "pPhoneNumber")
    private Integer phoneNumber;
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column (name = "pAddress")
    private Integer addressId;
    public Integer addressId() {
        return addressId();
    }
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Person() {}

    public Person(Integer id, String name, Integer phoneNumber, Integer addressId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }
}
