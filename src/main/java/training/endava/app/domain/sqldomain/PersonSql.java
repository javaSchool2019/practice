package training.endava.app.domain.sqldomain;

import java.util.Date;

public class PersonSql {
    private String name;
    private int id;
    private Date birthDay;
    private String birthPlace;
    private int addressId;

    public PersonSql(int id, Date birthDay, String birthPlace, int addressId) {
        this.id = id;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
