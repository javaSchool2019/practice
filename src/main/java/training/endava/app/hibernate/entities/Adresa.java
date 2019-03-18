package training.endava.app.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name="ADRESA")
@NamedQueries({
        @NamedQuery(name = "getById", query = "select ent from Adresa ent where ent.id =:id"),
})
public class Adresa {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer id;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "localitate")
    private String localitate;

    @Column(name = "oras")
    private String oras;

    public Adresa() {
    }

    public Adresa(Integer id, String adresa, String localitate, String oras) {
        this.id = id;
        this.adresa = adresa;
        this.localitate = localitate;
        this.oras = oras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }
}
