package training.endava.app.domain.entity;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "PERSON")
@DiscriminatorValue("P")

@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
})

public class Person extends Entity{
    private String name;
    private String surname;


    @JoinColumn(name = "description_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonDetails personDetails;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personDetails=" + personDetails +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }
}
