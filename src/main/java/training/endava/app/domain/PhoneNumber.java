package training.endava.app.domain;

import java.util.Objects;

public class PhoneNumber {
    private Long id;
    private String number;
    private String serviceProvider;

    public PhoneNumber(Long id, String number, String serviceProvider) {
        this.id = id;
        this.number = number;
        this.serviceProvider = serviceProvider;
    }

    public PhoneNumber() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return id.equals(that.id) &&
                number.equals(that.number) &&
                serviceProvider.equals(that.serviceProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, serviceProvider);
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
