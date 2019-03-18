package training.endava.app.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//@Entity
//@Table(name = "persons")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "entry_type",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("no")
public class YellowPageEntry {
    @NonNull
    private Integer person_id;
    @NotBlank
    private String name;

    public YellowPageEntry(Integer person_id, @NotBlank String name) {
        this.person_id = person_id;
        this.name = name;
    }

    public YellowPageEntry() {
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
