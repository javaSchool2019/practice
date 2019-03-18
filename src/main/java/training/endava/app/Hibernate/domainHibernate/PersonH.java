package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;

@Entity
@Table(name="Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class PersonH {

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
