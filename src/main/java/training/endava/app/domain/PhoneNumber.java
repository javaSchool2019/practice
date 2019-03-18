package training.endava.app.domain;

public class PhoneNumber {
    private int id;
    private String number;
    private String provider;
    private int personId;

    public PhoneNumber(Integer id, String phoneNumber, String provider, Integer personId) {
        this.id = id;
        number = phoneNumber;
        this.provider = provider;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}