package training.endava.app.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="PERSON", schema="hibernate", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    public Person() {
    }


    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' + "\n" +
                '}';
    }
}
