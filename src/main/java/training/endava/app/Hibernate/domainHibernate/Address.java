package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Address")
public class Address implements Serializable {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Transient
    @Column(name="number")
    private String number;

    public Address(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
