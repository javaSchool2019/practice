package training.endava.app.domain;

public class PhoneNumber {
    private Integer id;
    private Integer personId;
    private String number;
    private String serviceProvider;

    public PhoneNumber(Integer id, Integer personId, String number, String serviceProvider) {
        this.id = id;
        this.personId = personId;
        this.number = number;
        this.serviceProvider = serviceProvider;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
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

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }



}
