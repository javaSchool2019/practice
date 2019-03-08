package training.endava.playground.optionals;

import java.util.Optional;

public class Address {
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryOptional() {
        return Optional.ofNullable(country).orElse("DEFAULT_COUNTRY");
    }
}
