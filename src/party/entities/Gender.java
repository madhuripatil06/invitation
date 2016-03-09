package party.entities;

public enum Gender {
    Male("Mr"),
    Female("Ms");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return gender+" ";
    }
}
