package training.endava.app.filter;


import javax.validation.constraints.NotNull;

public class PersonDTO {

    @NotNull
    private Integer personID;
    private String personName;
    private String personAddress;

    public PersonDTO() {
    }

    public PersonDTO(@NotNull Integer personID, String personName, String personAddress) {
        this.personID = personID;
        this.personName = personName;
        this.personAddress = personAddress;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
