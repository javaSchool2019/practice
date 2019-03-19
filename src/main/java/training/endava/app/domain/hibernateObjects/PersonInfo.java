package training.endava.app.domain.hibernateObjects;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entry_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "person")

public class PersonInfo extends PageEntry {
    private Date birthday;
    private String birthplace;

    @Transient
    private String birthInfo;

    public PersonInfo(@NotBlank String name, Date birthday, String birthplace, AddressInfo addressInfo , List<PhoneNumber> phoneNumbers) {
        super(name,addressInfo,phoneNumbers);
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.birthInfo = birthplace.toString()+" "+birthday.toString();
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

    public String getBirthInfo() {
        this.birthInfo = birthplace.toString()+" "+birthday.toString();
        return birthInfo;
    }
}





















//
//    req -> addPerson -> (name, birthPlace, birthDay, addressId)
//
//    get -> getById -> from persons,
//            get from address -> address,
//            get from phoneNumber -> list<PhoneNumbers>




















