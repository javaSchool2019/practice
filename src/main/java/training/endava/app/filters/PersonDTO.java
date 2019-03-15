package training.endava.app.filters;

import training.endava.app.domain.Adress;
import training.endava.app.domain.PhoneNumber;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

public class PersonDTO {

    @NotNull
    private String personName;

    @NotNull
    private PhoneNumber personPhoneNumber;

    @NotNull
    private Adress personAdress;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public PhoneNumber getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(PhoneNumber personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public Adress getPersonAdress() {
        return personAdress;
    }

    public void setPersonAdress(Adress personAdress) {
        this.personAdress = personAdress;
    }
}
