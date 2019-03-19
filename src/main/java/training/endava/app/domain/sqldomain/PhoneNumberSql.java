package training.endava.app.domain.sqldomain;

public class PhoneNumberSql {
    private int id;
    private String number;
    private String serviceProvider;
    private int personId;

    public PhoneNumberSql(int id, String number, String serviceProvider, int personId) {
        this.id = id;
        this.number = number;
        this.serviceProvider = serviceProvider;
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

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
