package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phoneNumberTable")
public class PhoneNumber implements Serializable {
    @Id
    @Column(name = "pnId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {this.id = id;}

    @Column (name = "pnNumber")
    private Integer phoneNumber ;
    public Integer getPhoneNumberPerson() {
        return phoneNumber;
    }
    public void setPhoneNumberPerson(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber(){

    }
    public PhoneNumber(Integer id, Integer phoneNumber){
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

}
