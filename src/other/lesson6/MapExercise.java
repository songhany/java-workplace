package other.lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapExercise {

    public static void main(String[] args) {
        Map<String, Person> mapOfPeople = new HashMap<String, Person>();
        Person mike = new Person("Mike", "mike@gmail.com");
        Person alice = new Person("Alice", "alice@gmail.com");
        Person sally = new Person("Sally", "sally@gmail.com");
        Person songhan = new Person("Songhan", "songhan@gmail.com");
        //mapOfPeople.put(mike.getEmail(), mike);
        //mapOfPeople.put(alice.getEmail(), alice);
        //mapOfPeople.put(sally.getEmail(), sally);
        //mapOfPeople.put(songhan.getEmail(), songhan);

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(mike);
        people.add(alice);
        people.add(sally);
        people.add(songhan);

        for (Person person: people) {
            mapOfPeople.put(person.getEmail(), person);
        }

        for (String email: mapOfPeople.keySet()) {
            System.out.println(email);
        }

        for (Person person: mapOfPeople.values()) {
            System.out.println(person);
        }

        System.out.println("Get Songhan: " + mapOfPeople.get("songhan@gmail.com"));
        System.out.println("Contains Mike: " + mapOfPeople.containsKey("mike@gmail.com"));
    }
}
