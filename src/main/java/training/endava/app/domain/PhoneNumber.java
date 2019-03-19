package training.endava.app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Column(name = "provider", length = 20)
    private String provider;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
