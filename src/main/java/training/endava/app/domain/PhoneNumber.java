package training.endava.app.domain;

public class PhoneNumber {
    private int id;
    private String number;
    private String serviceProvider;


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

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }



}
