package training.endava.app.domain.entity;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "PERSON_DETAILS")

public class PersonDetails {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "description_id")
    private String description;

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
