package party.application;

public abstract class Style{
    private String option;
    Style(String option){this.option = option;}
    public abstract String represent(String first, String last);

    public static final Style FirstLast = new FirstLast(), LastFirst = new LastFirst();
    public static Style parse(String option){
        Style[] items = new Style[]{FirstLast, LastFirst};
        for (Style item : items) {
            if(item.option.equals(option)) return item;
        }
        return  null;
    }
}
class FirstLast extends Style{
    public FirstLast() {
        super("-f");
    }
    @Override
    public String represent(String first, String last) {
        return first+" "+last;
    }
}

class LastFirst extends Style{
    public LastFirst() {
        super("-l");
    }

    @Override
    public String represent(String first, String last) {
        return last + ", "+first;
    }
}