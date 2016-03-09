package party.filters;

import party.entities.Person;

public class AgeFilter implements Filter {
    private int age;

    public AgeFilter(int age) {
        this.age = age;
    }

    @Override
    public boolean isValid(Person guest) {
        return guest.HowOldAreYou() >= age;
    }

    @Override
    public String getEntity(Person guest) {
        return guest.HowOldAreYou()+"";
    }
}
