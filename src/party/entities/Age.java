package party.entities;

public class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public String toText(){
        return age+"";
    }

    public boolean isAbove(int minAge){
        return minAge < age;
    }
}
