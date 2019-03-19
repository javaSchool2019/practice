package training.endava.app.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import training.endava.app.domain.PhoneNumber;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class PhoneNumberDto {
    @NotBlank
    private String number;

    @NotBlank
    private String provider;

    public PhoneNumber toPhoneNumber(){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(getNumber());
        phoneNumber.setProvider(getProvider());
        return phoneNumber;
    }
}
