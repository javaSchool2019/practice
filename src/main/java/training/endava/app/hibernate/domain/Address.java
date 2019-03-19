package training.endava.app.hibernate.domain;


import javax.persistence.*;

@Entity
@Table(name="ADDRESS", schema="hibernate", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="personId")
    private Integer personId;


    @Column(name="street")
    private String street;


    @Column(name="city")
    private String city;


    @Column(name="country")
    private String country;

    @Transient
    private Integer countryCode = 1; // caput inspiratie astazi



    public Address() {
    }


    public Address(Integer id, Integer personId, String street, String city, String country) {
        this.id = id;
        this.personId = personId;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "AddressService{" +
                "id=" + id +
                ", personId=" + personId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", countryCode=" + countryCode + "\n" +
                '}';
    }


}

