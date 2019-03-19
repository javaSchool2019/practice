package training.endava.app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "yellow_page_entry")
@DiscriminatorValue("P")
public class Person extends YellowPageEntry implements Serializable {

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
