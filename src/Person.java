public class Person {
    private Address address;
    private Name name;
    public int age;

    public Person(Name name ,int age,Address address) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getNameInOrderFirstLast() {
        return name.nameFirstLast();
    }

    public String getNameInOrderLastFirst() {
        return name.nameLastFirst();
    }

    public String getCountry() {
        return address.getCountry();
    }

}
