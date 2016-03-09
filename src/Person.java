public class Person {
    private String gender;
    private Address address;
    private Name name;
    public int age;

    public Person(Name name, String gender, Address address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getNameInOrderFirstLast() {
        return String.format("%s%s", Gender.valueOf(gender), name.nameFirstLast());
    }

    public String getNameInOrderLastFirst() {
        return String.format("%s%s", Gender.valueOf(gender), name.nameLastFirst());
    }

    public String getCountry() {
        return address.getCountry();
    }

    public boolean  isFromCountry(String otherCountry){
        return address.getCountry().equals(otherCountry);
    }
}
