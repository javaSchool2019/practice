package training.endava.app.domain;

public class Address {
    private long id;
    private String city;
    private String country;
    private String street;

    public Address(long id, String city, String country, String street) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.street = street;
    }


}
