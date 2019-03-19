package training.endava.app.payload;


import training.endava.app.domain.entity.Person;
import training.endava.app.domain.entity.PersonDetails;
import training.endava.app.domain.entity.PhoneNumber;

import java.util.List;

public class PersonDTO {
    private String name;
    private PersonDetails personDetails;
    private String surName;
    private String address;
    private List<PhoneNumber> phoneNumbers;

    public String getName() {
        return name;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setName(String name) {
        this.name = name;
    }
}
