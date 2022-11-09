package other.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StringSorting {

    public static void main(String[] args) {
        List<String> strings = new LinkedList<String>();

        strings.add("Zed");
        strings.add("Alice");
        strings.add("Mike");

        //Before Sorting
        for (String string: strings) {
            System.out.println(string);
        }

        //sorting
        Collections.sort(strings);
        System.out.println("------Sorted------");

        //after sorting
        for (String string: strings) {
            System.out.println(string);
        }
    }
}
