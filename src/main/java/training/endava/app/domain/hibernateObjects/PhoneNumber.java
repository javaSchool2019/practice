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

    public PhoneNumber(String number) {
        this.number = number;
    }

    public PhoneNumber(){}

    public Integer getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Integer phone_id) {
        this.phone_id = phone_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
