package laiBasic;

public class MergeSortForLinkedList {
    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        // de-link
        middle.next = null;
        // sort each half
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);
        // combine two halves
        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {  // TC: O(n) SC: O(1)
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( one != null && two != null ) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }

        // if one of Linked List has remaining element
        if ( one != null) {
            cur.next = one;
        }
        if ( two != null) {
            cur.next = two;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeSortForLinkedList solution = new MergeSortForLinkedList();

        // BigIntegerTest case to cover possible situation
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head = solution.mergeSort(head);
        ListNode cur = head;
        while(cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

}
