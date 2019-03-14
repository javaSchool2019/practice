package training.endava.app.filters;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

public class PersonDTO {

    @NotNull
    private String personName;

    @NotNull
    private String personPhoneNumber;

    @NotNull
    private String personAdress;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber.substring(0,3)+"XXXXXXX";
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonAdress() {
        return personAdress;
    }

    public void setPersonAdress(String personAdress) {
        this.personAdress = personAdress;
    }
}
