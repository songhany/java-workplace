package other.lesson3.inheritanceExample;

public class PersonTester {

    public static void main (String[] args) {
        Person songhan = new Person("Songhan", "Yu");
        System.out.println(songhan);

        Student ricardo = new Student("Ricardo", "Lu", "12345");
        System.out.println(ricardo);

        StudentEmployee jeff = new StudentEmployee("Jeff", "Sam", "4567", "#12345", 20.5);
        System.out.println(jeff);
    }
}
