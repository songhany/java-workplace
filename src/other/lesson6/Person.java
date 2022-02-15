package other.lesson6;

public class Person {

    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName() {
        this.name = name;
    }

    public void setEmail() {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Email: " + email;
    }
}
