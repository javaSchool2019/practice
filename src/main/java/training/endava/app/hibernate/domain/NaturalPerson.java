package training.endava.app.hibernate.domain;


import javax.persistence.*;

@Entity
@Table(name="PERSON", schema="hibernate")
@DiscriminatorValue("NP")
public class NaturalPerson extends Person {

    @Column(name="birthday")
    private String birthday;

    @Column(name="birthplace")
    private String birthplace;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }



}
