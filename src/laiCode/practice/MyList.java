package laiCode.practice;

public interface MyList {
    public boolean set(int index, int value);
    public Integer get(int index);
}

class ListNode {
    int value;
    ListNode next;
    public ListNode(int v) {
        this.value = v;
    }
}

class ArrayList1 implements MyList {
    int[] array;
    @Override
    public boolean set(int index, int value) {
        // ...
        array[index] = value;
        return true;
    }

    @Override
    public Integer get(int index) {
        // ...
        return array[index];
    }
}

class LinkedList1 implements MyList {
    ListNode head;
    ListNode tail;
    @Override
    public boolean set(int index, int value) {
        // ...
        return true;
    }

    @Override
    public Integer get(int index) {
        return 1;
    }
}

class Solution {
    public static void main(String[] args) {
        // MyList l1 = new MyList();  // Wrong. MyList is Interface that cannot be instantiated
        MyList l2 = new LinkedList1();
        MyList l3 = new ArrayList1();
    }
}
