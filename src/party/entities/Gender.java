package party.entities;

public enum Gender {
    MALE("Mr"),
    FEMALE("Ms");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return gender+" ";
    }
}
