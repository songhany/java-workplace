package laiCode.compare;

import java.util.*;

public class PriorityQueueCompareLogic {
    public static void main(String[] args) {
        PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>();
        pqMinHeap.offer(3);
        pqMinHeap.offer(1);
        pqMinHeap.offer(2);
        while (!pqMinHeap.isEmpty()) {
            System.out.println(pqMinHeap.poll());
        }

        PriorityQueue<Integer> pqMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        pqMaxHeap.offer(3);
        pqMaxHeap.offer(1);
        pqMaxHeap.offer(2);
        while (!pqMaxHeap.isEmpty()) {
            System.out.println(pqMaxHeap.poll());
        }
    }
}
