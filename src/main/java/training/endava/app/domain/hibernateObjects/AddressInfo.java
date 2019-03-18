package training.endava.app.domain.hibernateObjects;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressInfo {
    @Id
    @GeneratedValue
    private Integer address_id;

    @NonNull
    private String country;
    @NonNull
    private String city;
    @NonNull
    private String street;

    public AddressInfo(Integer address_id, String country, String city, String street) {
        this.address_id = address_id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

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
}
