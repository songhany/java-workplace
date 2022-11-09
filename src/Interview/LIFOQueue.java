package Interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LIFOQueue {
    public static void main(String[] args) {
        Queue<Integer> q = Collections.asLifoQueue(new LinkedList<>());  // use a method requiring a Queue but you need Last-in-first-out (Lifo) Queue ordering
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q);
        q.poll();
        System.out.println(q);
    }
}
