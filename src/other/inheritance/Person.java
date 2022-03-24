package other.inheritance;

public class Person {

    private String firstName;
    private String lastName;

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName;
    }

    public static void main (String[] args) {
        Person songhan = new Person("Songhan", "Yu");
        System.out.println(songhan);

        Student ricardo = new Student("Ricardo", "Lu", "12345");
        System.out.println(ricardo);

        StudentEmployee jeff = new StudentEmployee("Jeff", "Sam", "4567", "#12345", 20.5);
        System.out.println(jeff);
    }
}
