package other.collections;

import java.util.ArrayList;
import java.util.Collections;

public class PersonSort {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person( "Same"));
        people.add(new Person( "Mike"));
        people.add(new Person( "Apple"));

        for (Person person: people) {
            System.out.println(person.name);
        }

        Collections.sort(people);
        System.out.println("------Sorted------");

        for (Person person: people) {
            System.out.println(person.name);
        }
    }
}
