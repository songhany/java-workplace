package other;

public class Person1 {
    private final String name;
    private final String email;

    public Person1(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " " + email;
    }
}
