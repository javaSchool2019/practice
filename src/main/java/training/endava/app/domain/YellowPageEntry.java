package training.endava.app.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "yellow_page_entry")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entry_type", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")
public class YellowPageEntry {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
    @JoinColumn(name = "entry_id")
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
