package training.endava.app.DTOMapper;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDTO {
    @NotBlank
    private String name;

    public PersonDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
