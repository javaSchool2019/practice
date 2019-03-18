package training.endava.app.domain.hibernateObjects;

import org.springframework.lang.NonNull;
import training.endava.app.domain.YellowPageEntry;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entry_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "company")

public class Company extends PageEntry {

    Date foundingYear;
    @NonNull
    Integer address_id;

    public Company(@NotBlank String name, Date foundingYear, Integer address_id) {
        super(name);
    }

    public Date getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(Date foundingYear) {
        this.foundingYear = foundingYear;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }
}
