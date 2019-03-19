package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="NeutralPerson")
@DiscriminatorValue("N")
public class NeutralPerson extends PersonH implements Serializable {

    @Column(name="sirName")
    private String sirName;
    public NeutralPerson(){}


    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }
}
