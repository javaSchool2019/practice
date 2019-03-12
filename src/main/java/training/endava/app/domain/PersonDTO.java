package training.endava.app.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDTO {
    private String personName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
