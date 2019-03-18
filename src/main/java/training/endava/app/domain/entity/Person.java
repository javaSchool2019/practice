package training.endava.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "PERSON")
@DiscriminatorValue("P")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person extends Entity{
    private String name;
    private String surname;


    @JoinColumn(name = "description_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonDetails personDetails;
}
