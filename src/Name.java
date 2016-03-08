public class Name {
    private String firstName;
    private String lastName;
    private String gender;

    public Name(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String nameFirstLast(){
        return Gender.valueOf(this.gender) + this.firstName+" "+this.lastName;
    }

    public String nameLastFirst(){
        return Gender.valueOf(this.gender) + this.lastName+", "+this.firstName;
    }
}
