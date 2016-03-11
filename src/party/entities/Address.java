package party.entities;

public class Address {
    private String city;
    private String state;
    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String toString(){
        return String.format("%s, %s, %s",city,state,country);
    }

    public boolean isFromCountry(String otherCountry) {
        return country.equals(otherCountry);
    }
}
