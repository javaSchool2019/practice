package training.endava.app.dto;

public class PersonDTO {
    private Integer personId;
    private String personName;
    private String personEmail;
    private String personPhone;
    private String personAddress;

    public PersonDTO() {
    }


    public PersonDTO(Integer personId, String personName, String personEmail, String personPhone, String personAddress) {
        this.personId = personId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.personAddress = personAddress;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
