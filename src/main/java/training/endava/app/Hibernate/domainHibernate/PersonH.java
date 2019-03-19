package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class PersonH implements Serializable {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="id_address")
    private String id_address;

    @Column(name="id_contact")
    private String id_contact;

    public PersonH(){}

    public PersonH(int id, String name, String id_address, String id_contact) {
        this.id = id;
        this.name = name;
        this.id_address = id_address;
        this.id_contact = id_contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
