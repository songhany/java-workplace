package laiBasic;

import java.util.ArrayList;

public class ArrayToLinkedList {
	static class ListNode {
		public int value;
		public ListNode next;

		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

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

	public static void main(String[] args) {
		// Single element array
		int [] array1 = {1};
		ListNode l1 = ArrayToLinkedList.arrayToNode(array1);
		ArrayToLinkedList.printLinkedList(l1);


		int [] array2 = {1,2,3};
		ListNode l2 = ArrayToLinkedList.arrayToNode(array2);
		ArrayToLinkedList.printLinkedList(l2);

		int [] array3 = {1,2,3,4,5,6};
		ListNode l3 = ArrayToLinkedList.arrayToNode(array3);
		ArrayToLinkedList.printLinkedList(l3);


		// Empty array
		int [] array4 = {};
		ListNode l4 = ArrayToLinkedList.arrayToNode(array4);
		ArrayToLinkedList.printLinkedList(l4);
	}
}
