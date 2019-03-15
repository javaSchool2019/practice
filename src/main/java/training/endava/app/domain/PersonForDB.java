package training.endava.app.domain;

public class PersonForDB {

    private Integer id;
    private String name;
    private Integer adressId;
    private String birthday;

    public PersonForDB(Integer id, String name, Integer adressId, String birthday) {
        this.id = id;
        this.name = name;
        this.adressId = adressId;
        this.birthday = birthday;
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

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PersonForDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adressId=" + adressId +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
