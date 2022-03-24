package laiCode;
// Input:  a singly LinkedList N1 -> N2 -> N3 -> ... -> Nn -> null
// Output:  N1 -> Nn -> N2 -> Nn-2 -> N3 -> Nn-2 -> ... -> null

//! 这个代码有问题
public class ReorderList {
    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int v) {
            value = v;
            next = null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = next;
            while (cur != null) {
                sb.append(cur.value).append(" -> ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddleNode(head);  // 1. find the middle node
        ListNode one = head;
        ListNode two = mid.next;
        // de-link the second half from the list
        mid.next = null;
        // 2. reverse the second half
        // 3. merge the two halves
        return merge(one, reverseByRecursion(two));
    }

    private ListNode findMiddleNode(ListNode head) {  // 快慢指针
/*      1 2 3
          s
            f
        1 2 3 4
          s
            f
*/
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {  // iterasive 反转链表
        /*
             1 -> 2 -> 3 -> 4 -> null
             c
                  n

     null <- 1 <- 2  <-  3  <- 4
                               p
                                   c
                                   n

        * */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-10);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;

            cur.next.next = two;
            two = two.next;

            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReorderList sol = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head.toString());
        System.out.println(sol.reorder(head));
    }

    private ListNode reverseByRecursion(ListNode head) {
        /*    1   2    3
        *
        * */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
