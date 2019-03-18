package training.endava.app.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "PERSON_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "description_id")
    private String description;
}
