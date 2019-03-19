package training.endava.app.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import training.endava.app.domain.Person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PersonDto {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private AddressDto address;

    private List<PhoneNumberDto> phoneNumberList;

    public Person toPerson() {
        Person person = new Person();
        person.setFirstName(getFirstName());
        person.setLastName(getLastName());
        person.setAddress(address.toAddress());
        person.setPhoneNumbers(phoneNumberList.stream()
                .map(PhoneNumberDto::toPhoneNumber)
                .collect(Collectors.toList()));
        return person;
    }
}
