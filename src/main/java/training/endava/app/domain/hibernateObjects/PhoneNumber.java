package training.endava.app.domain.hibernateObjects;


import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Integer entry_id;
}
