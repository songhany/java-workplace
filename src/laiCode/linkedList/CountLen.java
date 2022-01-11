package laiCode.linkedList;

public class CountLen {
    public int count(ListNode head) {
        // corner case check
        if (head == null) {
            return 0;
        }

        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
