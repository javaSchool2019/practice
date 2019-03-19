package training.endava.app.hibernate.domain;


import javax.persistence.*;

@Entity
@Table(name="PHONENUMBER", schema="hibernate", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class PhoneNumber {

    @Id
    @Column(name="id", nullable = false)
    private Integer id;


    @Column(name="personId")
    private Integer personId;


    @Column(name="number")
    private String number;

    @Column(name="serviceProvider")
    private String serviceProvider;



    public PhoneNumber() {
    }
    public PhoneNumber(Integer id, Integer personId, String number, String serviceProvider) {
        this.id = id;
        this.personId = personId;
        this.number = number;
        this.serviceProvider = serviceProvider;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }


}
