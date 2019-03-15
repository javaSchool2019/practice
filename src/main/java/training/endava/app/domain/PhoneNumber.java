package training.endava.app.domain;

public class PhoneNumber {

    private Integer id;
    private String number;
    private String service_provider;
    private Integer personId;

    public PhoneNumber(Integer id, String number, String service_provider, Integer personId) {
        this.id = id;
        this.number = number;
        this.service_provider = service_provider;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getService_provider() {
        return service_provider;
    }

    public void setService_provider(String service_provider) {
        this.service_provider = service_provider;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", service_provider='" + service_provider + '\'' +
                ", personId=" + personId +
                '}';
    }
}
