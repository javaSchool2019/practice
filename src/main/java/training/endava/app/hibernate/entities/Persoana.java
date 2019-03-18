package training.endava.app.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PERSOANA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIP_PERSOANA", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class Persoana implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adresa")
    private Integer adressId;

    @Column(name = "numarDeTelefon")
    private Integer telefonId;


    public Persoana() {
    }

    public Persoana(Integer id, String name, Integer adressId, Integer telefonId) {
        this.id = id;
        this.name = name;
        this.adressId = adressId;
        this.telefonId = telefonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public Integer getTelefonId() {
        return telefonId;
    }

    public void setTelefonId(Integer telefonId) {
        this.telefonId = telefonId;
    }
}
