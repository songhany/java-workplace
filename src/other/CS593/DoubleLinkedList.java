package other.CS593;

public class DoubleLinkedList {
	private static class Node { // static class in Java does not have pointer to the container
		Node next;
		Node prev;
		int val;

		public Node(int v) {
			val = v;
		}
	}

	private Node head;
	private Node tail;
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}

	public void addStart(int v) {
		Node tmp = new Node(v);
		tmp.next = head;
		tmp.prev = null;
		if (head == null) {
			tail = tmp;
		} else {
			head.prev = tmp;
		}
		head = tmp;      // make tmp as newHead
	}

	public void addEnd(int v) {
		Node tmp = new Node(v);
		tmp.prev = tail;
		tmp.next = null;
		if (tail == null) {
			head = tmp;
		} else {
			tail.next = tmp;
		}
		tail = tmp;     // make tmp as newTail
	}

	public void removeStart() {
		if (head == null) {
			return;
		}
		if (head.next == null) {
			head = null;
			tail = null;
			return;
		}
		head = head.next;
		head.prev = null;
	}

	public void removeEnd() {
		if (tail == null) {
			return;
		}
		if (tail.prev == null) {
			head = null;
			tail = null;
			return;
		}
		// At least 2 node
		tail = tail.prev;
		tail.next = null;
	}

	// insert v before pos. insert(0,v) would insert at the front.
	public void insert(int pos, int v) {
		if (pos == 0) {   // addStart
			addStart(v);
		}
		int cnt = 0;
		Node cur = head;
		Node tmp = new Node(v);
		while ((cnt + 1) != pos) {
			cur = cur.next;
			cnt++;
		}
		tmp.next = cur.next;
		tmp.prev = cur;
		cur.next = tmp;
	}

	// implement to print out the list
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		while (cur != null) {
			sb.append(cur.val).append(" ");
			cur = cur.next;
		}
		return sb.toString();
//		String s = "";
//		for (Node cur = head; cur != null; cur = cur.next) {
//			s = s + cur.val + ", ";
//		}
//		return s;
	}

	public static void main(String[] args) {
		DoubleLinkedList a = new DoubleLinkedList();
		final int n = 1000000;
		for (int i = 0; i < n; i++)
			a.addStart(i);
		for (int i = 0; i < n; i++)
			a.addEnd(i);
		for (int i = 0; i < 3*n/2; i++)
			a.removeStart();

		for (int i = 0; i < n/2 - 5; i++)
			a.removeEnd();
		System.out.println(a);

		for (int i = 0; i < 10; i++)
			a.insert(1, i);
		System.out.println(a);
	}
}
