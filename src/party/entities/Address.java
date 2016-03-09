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
        return city + ", "+this.state + " "+this.country;
    }

    public boolean isFromCountry(String country) {
        return this.country.equals(country);
    }

    public String getCountry() {
        return country + "";
    }
}
