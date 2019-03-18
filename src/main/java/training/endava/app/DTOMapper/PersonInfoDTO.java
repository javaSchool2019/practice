package training.endava.app.DTOMapper;

import javax.validation.constraints.NotBlank;

public class PersonInfoDTO {
    @NotBlank
    private String name;

    public PersonInfoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
