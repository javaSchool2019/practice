package training.endava.app.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="PERSOANA_JURIDICA")
@DiscriminatorValue("J")
public class PersoanaJuridica extends Persoana implements Serializable {

    @Column(name = "domeniuDeActivitate")
    private String domeniuDeActivitate;

    public PersoanaJuridica(String domeniuDeActivitate) {
        this.domeniuDeActivitate = domeniuDeActivitate;
    }

    public PersoanaJuridica(Integer id, String name, Integer adressId, Integer telefonId, String domeniuDeActivitate) {
        super(id, name, adressId, telefonId);
        this.domeniuDeActivitate = domeniuDeActivitate;
    }

    public PersoanaJuridica() {
    }

    public String getDomeniuDeActivitate() {
        return domeniuDeActivitate;
    }

    public void setDomeniuDeActivitate(String domeniuDeActivitate) {
        this.domeniuDeActivitate = domeniuDeActivitate;
    }
}
