package training.endava.app.domain.hibernateObjects;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;



@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entry_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "person")

public class PersonInfo extends PageEntry {
    private Date birthday;
    private String birthplace;
    @NonNull
    private Integer address_id;

    public PersonInfo(@NotBlank String name, Date birthday, String birthplace, Integer address_id) {
        super(name);
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.address_id = address_id;
    }

    public PersonInfo(){

    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }
}
