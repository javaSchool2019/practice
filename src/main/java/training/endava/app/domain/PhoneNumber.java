package training.endava.app.domain;

public class PhoneNumber {
    private long id;
    private String number;
    private String serviceProvider;

    public PhoneNumber(long id, String number, String serviceProvider) {
        this.id = id;
        this.number = number;
        this.serviceProvider = serviceProvider;
    }
}
