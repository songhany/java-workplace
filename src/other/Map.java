package other;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {

    public static void main(String[] args) {
        java.util.Map<String, other.Person1> mapOfPeople = new HashMap<String, other.Person1>();
        other.Person1 mike = new other.Person1("Mike", "mike@gmail.com");
        other.Person1 alice = new other.Person1("Alice", "alice@gmail.com");
        other.Person1 sally = new other.Person1("Sally", "sally@gmail.com");
        other.Person1 songhan = new other.Person1("Songhan", "songhan@gmail.com");
        //mapOfPeople.put(mike.getEmail(), mike);
        //mapOfPeople.put(alice.getEmail(), alice);
        //mapOfPeople.put(sally.getEmail(), sally);
        //mapOfPeople.put(songhan.getEmail(), songhan);

        ArrayList<other.Person1> people = new ArrayList<other.Person1>();
        people.add(mike);
        people.add(alice);
        people.add(sally);
        people.add(songhan);

        for (other.Person1 Person1: people) {
            mapOfPeople.put(Person1.getEmail(), Person1);
        }

        for (String email: mapOfPeople.keySet()) {
            System.out.println(email);
        }

        for (Person1 Person1: mapOfPeople.values()) {
            System.out.println(Person1);
        }

        System.out.println("Get Songhan: " + mapOfPeople.get("songhan@gmail.com"));
        System.out.println("Contains Mike: " + mapOfPeople.containsKey("mike@gmail.com"));
    }
}
