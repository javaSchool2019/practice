package training.endava.app.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "PHONE_NUMBER")
@NamedQueries({
        @NamedQuery(name = "PhoneNumber.findAll", query = "SELECT p FROM PhoneNumber p")
})
public class PhoneNumber implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public PhoneNumber() {
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
