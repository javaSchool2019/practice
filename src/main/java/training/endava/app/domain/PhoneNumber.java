package training.endava.app.domain;

public class PhoneNumber {

    private Integer id;
    private String phoneNumber;
    private String provider;
    private Integer personId;

    public PhoneNumber(Integer id, String phoneNumber, String provider, Integer personId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.provider = provider;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", provider='" + provider + '\'' +
                ", personId=" + personId +
                '}';
    }
}
