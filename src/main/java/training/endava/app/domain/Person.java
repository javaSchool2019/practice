package training.endava.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

}
