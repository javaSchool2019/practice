package training.endava.app.payload;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
