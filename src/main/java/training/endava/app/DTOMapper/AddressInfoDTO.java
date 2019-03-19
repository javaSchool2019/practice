package training.endava.app.DTOMapper;

import org.springframework.lang.NonNull;
import training.endava.app.domain.hibernateObjects.AddressInfo;
import training.endava.playground.optionals.Address;

public class AddressInfoDTO {

    private String country;
    private String city;
    private String street;

    public AddressInfoDTO(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public AddressInfoDTO() {
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

    public AddressInfo toAddressInfo(){
        return new AddressInfo(this.country,
        this.city,
        this.street);
    }
}
