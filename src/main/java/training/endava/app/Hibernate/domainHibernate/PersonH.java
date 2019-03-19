package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class PersonH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> contact;

    public PersonH() {
    }

    public PersonH(int id, String name) {
        this.id = id;
        this.name = name;


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
