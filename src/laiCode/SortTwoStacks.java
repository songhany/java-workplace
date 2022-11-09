package laiCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
*  global min =
*  count =
*  Stack1 input [
*  Stack2 buffer [
*  Stack3 result [
* */

public class SortTwoStacks {
    // sort in ascending order and store result in buffer
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1, s2);
    }

    private void sort(Deque<Integer> input, Deque<Integer> buffer) {
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;  // record duplicated curMin
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur);
            }

            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int tmp = buffer.pollFirst();
                if (tmp != curMin) {
                    input.offerFirst(tmp);
                }
            }

            while (count > 0) {
                buffer.offerFirst(curMin);
                count--;
            }
        }

        while (!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }
    }

    public static void main(String[] args) {
        SortTwoStacks sol = new SortTwoStacks();
        LinkedList<Integer> numbers = new LinkedList<>(List.of(4, 2, 3, 9, 1));
        sol.sort(numbers);
//        sol.sort(new LinkedList<Integer>(Arrays.asList(4, 2, 3, 9, 1)));

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(i +" = "+numbers.get(i));
        }
    }
}

