
public class testProgram {

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
