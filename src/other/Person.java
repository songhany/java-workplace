package other;

public class Person {
    private String firstName;
    private String lastName;

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name: " + lastName + " " + firstName;
    }

    public static void main (String[] args) {
        Person bob = new Person("Bob", "Phillips");
        Person mike = new Person("Mike", "Lipson");
        System.out.println(bob);
        System.out.println(mike);
    }
}
