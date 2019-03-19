package training.endava.app.DTOMapper;

import org.springframework.lang.NonNull;
import training.endava.app.domain.hibernateObjects.PhoneNumber;

public class PhoneNumberDTO {

    private String number;

    public PhoneNumberDTO(String number) {
        this.number = number;
    }

    public PhoneNumberDTO(){

    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber toPhoneNumber(){
        return new PhoneNumber(this.number);
    }
}
