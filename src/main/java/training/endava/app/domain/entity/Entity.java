package training.endava.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOY_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PhoneNumber> phoneNumbers;
    private String address;

}


