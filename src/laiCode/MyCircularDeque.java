package laiCode;

// https://app.laicode.io/app/problem/613
public class MyCircularDeque {
    private int head;  // Front
    private int tail;  // Last
    private int size;   // number of element in deque currently
    private int[] arr;
    private int capacity;  // size of deque

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        arr[head] = value;

        if (isEmpty()) {
            head = (head - 1 + capacity) % capacity;
            tail = (tail + 1) % capacity;
        } else {
            head = (head - 1 + capacity) % capacity;
        }

        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        arr[tail] = value;

        if (isEmpty()) {
            head = (head - 1 + capacity) % capacity;
            tail = (tail + 1 + capacity) % capacity;
        } else {
            tail = (tail + 1 + capacity) % capacity;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = (head + 1 + capacity) % capacity;
            tail = (tail - 1 + capacity) % capacity;
        } else {
            head = (head + 1 + capacity) % capacity;
        }
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = (head + 1 + capacity) % capacity;
            tail = (tail - 1 + capacity) % capacity;
        } else {
            tail = (tail - 1 + capacity) % capacity;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1: arr[(head + 1 + capacity) % capacity];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1: arr[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
//		String s = "";
//		for (Node cur = head; cur != null; cur = cur.next) {
//			s = s + cur.val + ", ";
//		}
//		return s;
    }
    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        obj.insertFront(1);
        obj.insertFront(2);
        obj.insertFront(3);
        System.out.println(obj.toString());
        obj.deleteLast();
        obj.deleteLast();
        obj.deleteLast();

        obj.insertLast(1);
        obj.insertLast(2);
        System.out.println(obj.toString());
        obj.isEmpty();
        obj.isFull();
        obj.deleteFront();
        obj.isEmpty();

        obj.insertFront(2020);
        obj.insertFront(2021);
        obj.insertLast(2022);
        obj.getFront();
        obj.getRear();
        obj.isEmpty();
        obj.isFull();
        System.out.println(obj.toString());
    }
}