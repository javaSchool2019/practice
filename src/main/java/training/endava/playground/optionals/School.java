package training.endava.playground.optionals;

import java.util.Optional;

public class School {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAdressOptional() {
        return Optional.ofNullable(address).orElseGet(() -> new Address());
    }
}
