import java.util.ArrayList;

class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class ArrayToLinkedList {
	public static ListNode arrayToNode(int[] arr) {
		// If the array is empty, do nothing
		if(arr.length == 0)
			return null;
		
		// Create head of a new linked list
		ListNode head = new  ListNode(arr[0]);
		ListNode previous = head;

		// Create a new node for each element in the array
		// and concatenate them to form a linked list
		for (int i = 1; i < arr.length; i++) {
			ListNode currentNode = new ListNode(arr[i]);
			previous.next = currentNode;
			previous = currentNode;
		}

		return head;
	}
	
	public static void printLinkedList(ListNode node) {
		// Do nothing with an empty linked list
		if(node == null)
			return;
		
		// Put elements in the linked list to an arraylist so
		// that we can print them easily
		ArrayList<Integer> list = new ArrayList<>();
        while(node != null){
            list.add(node.value);
            node = node.next;
        }
        System.out.println(list);

	}
}
