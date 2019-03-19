package training.endava.app.hibernate.domain;

import javax.persistence.*;

@Entity
@Table(name="PERSON", schema="hibernate")
@DiscriminatorValue("LP")
public class LegalPerson extends Person {

    @Column(name="nrOfEmployee")
    private Integer nrOfEmployee;

    public Integer getNrOfEmployee() {
        return nrOfEmployee;
    }

    public void setNrOfEmployee(Integer nrOfEmployee) {
        this.nrOfEmployee = nrOfEmployee;
    }


}
