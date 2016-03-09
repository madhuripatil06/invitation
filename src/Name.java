public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String nameFirstLast(){
        return  this.firstName+" "+this.lastName;
    }

    public String nameLastFirst(){
        return this.lastName+", "+this.firstName;
    }
}
