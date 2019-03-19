package training.endava.app.hibernate.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PERSOANA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIP_PERSOANA", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class Persoana implements Serializable {

    @Id
    @Column(name = "id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "adresa")
    private Adresa adressId;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "numarDeTelefon")
    private NumarDeTelefon telefonId;


    public Persoana() {
    }

    public Persoana(Integer id, String name, Adresa adressId, NumarDeTelefon telefonId) {
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

    public Adresa getAdressId() {
        return adressId;
    }

    public void setAdressId(Adresa adressId) {
        this.adressId = adressId;
    }

    public NumarDeTelefon getTelefonId() {
        return telefonId;
    }

    public void setTelefonId(NumarDeTelefon telefonId) {
        this.telefonId = telefonId;
    }
}
