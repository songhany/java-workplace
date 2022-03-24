package other.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WrapperSorting {

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<Integer>();

        numbers.add(201);
        numbers.add(100);
        numbers.add(101);

        //Before Sorting
        for (Integer number: numbers) {
            System.out.println(number);
        }

        //sorting
        Collections.sort(numbers);
        System.out.println("------Sorted------");

        //after sorting
        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
