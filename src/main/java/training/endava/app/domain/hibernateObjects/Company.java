package training.endava.app.domain.hibernateObjects;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entry_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "company")

public class Company extends PageEntry {

    Date founding_year;

    public Company(String name, AddressInfo addressInfo, List<PhoneNumber> phoneNumberList, Date foundingYear) {
        super(name, addressInfo, phoneNumberList);
        this.founding_year = foundingYear;
    }

    public Company(){

    }

    public Date getFounding_year() {
        return founding_year;
    }

    public void setFounding_year(Date founding_year) {
        this.founding_year = founding_year;
    }

}
