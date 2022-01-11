package laiCode.linkedList;

public class InsertNodeWithDummy {
    public ListNode insert(ListNode head, int target) {
        ListNode targetNode = new ListNode(target);

        // corner case
        if (head == null) {
            return targetNode;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.value < target) {
            pre = pre.next;
            cur = cur.next;
        }

        targetNode.next = cur;
        pre.next = targetNode;
        return dummy.next;
    }

}
