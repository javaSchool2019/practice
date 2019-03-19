package training.endava.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="YELLOW_PAGES")
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTRY_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")
public class YellowPageEntry implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
