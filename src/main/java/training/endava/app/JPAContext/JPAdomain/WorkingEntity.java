package training.endava.app.JPAContext.JPAdomain;

import javax.persistence.*;

@Entity
@Table(name= "entities")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "E_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("WE")
public class WorkingEntity {

    //id, phone number, address, abstract OtherDetails
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    public Integer getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
