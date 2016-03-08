public class CountryFilter implements Filter {
    private String country;

    public CountryFilter(String country) {
        this.country = country;
    }

    @Override
    public boolean isValid(Person guest) {
        return guest.getCountry().equals(country);
    }

    @Override
    public String getEntity() {
        return country;
    }
}
