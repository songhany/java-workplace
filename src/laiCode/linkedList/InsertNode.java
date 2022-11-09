package laiCode.linkedList;

public class InsertNode {
    public ListNode insert(ListNode head, int target) {
        // create a newNode based on input target value
        ListNode new_node = new ListNode(target);

        // case 0: input LinkedList is null
        if (head == null) {
            return new_node;
        }

        // case 1: insert into the head
        if (target <= head.value) {
            new_node.next = head;
            return new_node;
        }

        // case 2 && 3: insert into middle or tail
        ListNode cur = head;
        while (cur.next != null && cur.next.value < target) {  // find the right position
            cur = cur.next;
        }

        new_node.next = cur.next;
        cur.next = new_node;
        return head;
    }
}
