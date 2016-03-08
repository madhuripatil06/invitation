public interface Filter {
    boolean isValid(Person guest);
    String getEntity();
}
