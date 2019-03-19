package training.endava.app.domain.hibernateObjects;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber implements Serializable {
    @Id
    @GeneratedValue
    private Integer phone_id;

    @NonNull
    private String number;

    @NonNull
    @OneToOne
    @JoinColumn(name = "id")
    private Integer entry_id;
}
