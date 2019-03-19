package training.endava.app.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("P")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Person extends YellowPageEntry {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Transient
    @Getter(AccessLevel.NONE)
    private String email;

    public String getEmail(){
        return (firstName + "." + lastName + "@endava.com").toLowerCase();
    }
}
