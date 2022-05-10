package other.CS570;

public class LinkedList {
	
	public class Node {
		public Object item;
		public Node next;
	}

	private int size;
	private Node head;
	 
	public LinkedList() {
		this.size = 0;
		this.head = null;
	}
	
	public void insertNode(String item) {
		Node node = new Node();
		node.item = item;
		Node current = this.head;

		//if head is empty, add the node to the beginning
		if (this.head == null) {
			this.head = node;
			this.head.next = null;
			this.size = 1;
			System.out.println(this.head.toString());
		} else {
			
			//traverse the node untuil you reach the end
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
			node.next = null;
			this.size += 1;
		}
	}
	
	public void insertFirst(String item){
		Node node = new Node();
		node.item = item;
		
		//point the node next to the head
		//head is our new node
		node.next = this.head;
		this.head = node;
		this.size++;
	}
	
	public void insertNth(String item, int position) {
		Node node = new Node();
		node.item = item;
		Node current = this.head;
		//make sure the head is not null and it is a valid position
		if (this.head != null && position <= this.size) {
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			
			//take the previous node adn point it to our new node
			//and point the nexxt of our new node to the old node in that position
			node.next = current.next;
			current.next = node;
			this.size += 1;
		}else{
			System.out.println("Exceeded the linked list size. Current Size: "+size);
		}
	}
	
	public void deleteFirstNode() {
		//to delete a nodek, you remove the pointer to that node
		if(head != null){
			this.head = this.head.next;
			this.size--;
		}else{
			System.out.println("Linked list is empty");
		}
	}
	
	//exercise wud be to delete the Nth node
	
	
	public void printNodes() {
		if (this.size < 1)
			System.out.println("There are no nodes in the linked list");
		else {
			Node current = this.head;
			for (int i = 0; i < this.size; i++) {
				System.out.println("Node " + current.item + " is at location " + i);
				current = current.next;
			}
		}
	}
	public int getListSize(){
		return size;
	}
	
	
	//other exercises would be create the entire class for double linked lists and circular linked lists
	//how would the functions be different for a double linked list
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println("Current Size of the list is: "+list.getListSize());
		
		list.insertNode("test1");
		list.insertNode("test2");
		list.insertNode("test3");
		list.insertNode("test4");
		list.insertNode("test5");
		list.insertNode("test6");
		list.insertNode("test7");
		
		list.insertFirst("First");
		list.insertNth("Nth item", 4);
		list.printNodes();
		
		
		//ArrayList is an array like data structure that offers dynamic resizing 
		//resizes itself as needed while still providing O(1) access
		
		//When the array becomes full , the array doubles in size and each doubling takes O(N) time 
		//but it happens so infrequently that the insertion time is still O(1)
		
		/*ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars.get(0);
	    cars.set(0, "Opel");
	    cars.remove(0);
	    
	    for (String i : cars) {
      		System.out.println(i);
    	}
	    
	    cars.clear();
	    cars.size();
	    */
	}
	
	

}
