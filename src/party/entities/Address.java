package party.entities;

public class Address {
    private String country;

    public Address(String country) {
        this.country = country;
    }

    public boolean isFromCountry(String country) {
        return this.country.equals(country);
    }
}
