package party.filters;

import party.entities.Person;

public class AgeFilter implements Filter {
    private int age;
    private int personage=0;

    public AgeFilter(int age) {
        this.age = age;
    }

    @Override
    public boolean isValid(Person guest) {
        personage = guest.HowOldAreYou();
        return guest.HowOldAreYou() >= age;
    }

    @Override
    public String getEntity() {
        return personage+"";
    }
}
