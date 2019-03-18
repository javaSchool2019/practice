package training.endava.app.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PERSOANA_FIZICA")
@DiscriminatorValue("F")
public class PersoanaFizica extends Persoana implements Serializable {
    @Column(name = "prenume")
    private String prenume;

    @Column(name = "eAngajat")
    private boolean eAngajat;

    public PersoanaFizica(Integer id, String name, Integer adressId, Integer telefonId, String prenume, boolean eAngajat) {
        super(id, name, adressId, telefonId);
        this.prenume = prenume;
        this.eAngajat = eAngajat;
    }

    public PersoanaFizica(String prenume, boolean eAngajat) {
        this.prenume = prenume;
        this.eAngajat = eAngajat;
    }

    public PersoanaFizica(){

    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public boolean iseAngajat() {
        return eAngajat;
    }

    public void seteAngajat(boolean eAngajat) {
        this.eAngajat = eAngajat;
    }
}
