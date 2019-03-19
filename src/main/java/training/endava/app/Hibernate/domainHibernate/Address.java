package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addressTable")
public class Address implements Serializable {
    @Id
    @Column(name = "aId")
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column (name = "aCity")
    private String city;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Transient
    private Integer postalCode;

    public Address(){

    }
    public Address(Integer id, String city, Integer postalCode){
        this.id = id;
        this.city = city;
        this.postalCode = postalCode;
    }


}
