package training.endava.app.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import training.endava.app.domain.Address;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AddressDto {
    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    public Address toAddress(){
        Address address = new Address();
        address.setCountry(getCountry());
        address.setCity(getCity());
        address.setStreet(getStreet());
        return address;
    }
}
