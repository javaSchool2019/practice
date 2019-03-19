package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
@DiscriminatorValue("C")
public class Company extends Person implements Serializable {

    @Column(name = "cWebsite")
    private String website;
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Company(){

    }
    public Company(String website){
        this.website = website;
    }
    public Company(Integer id, String name, Integer phoneNumber, Integer addressId, String website) {
        super(id, name, phoneNumber, addressId);
        this.website = website;
    }
}
