package other.CS570;


import java.io.IOException;
import java.util.Scanner;
  

public class ReverseLinkedList {
	
	static class Node {
        public int data;
        public Node next;
  
        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
  
    static class LinkedList {
        public Node head;
  
        public LinkedList() {
            this.head = null;
        }
  
        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);
  
            if (this.head != null) {
                node.next = head;
            } 
            this.head = node;
        }
    }
  
    /* Function to print linked list */
    public static void printSinglyLinkedList(Node node, String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data) + sep);
            node = node.next;
        }
    }
    
    static int sumLL(Node head) {
    	
    	Node n = head;
    	if (n == null)
    		return 0;
    	if (n.next == null)
    		return n.data;
    	return n.data + sumLL(n.next);
    }
    
    static int multLL(Node head, int mul) {
    	Node n = head;
    	if (n == null)
    		return -1;
    	
    	n.data *= mul;
    	return multLL(n.next,mul);
    		
    }


    static Node reverse(Node head) {
    	
        if(head == null) {
            return head;
        }
  
        // last node or only one node
        if(head.next == null) {
            return head;
        }
        
       
        
        Node newHeadNode = reverse(head.next);
        System.out.println("rev head:" + head.data);
        
        // change references for middle chain
       
        head.next.next = head;
        head.next = null;
        
       
        // send back new head node in every lai.Recursion
        return newHeadNode;
    }
  
    private static final Scanner scanner = new Scanner(System.in);
  
    public static void main(String[] args) throws IOException {
            LinkedList llist = new LinkedList();
          
            llist.insertNode(20);
            llist.insertNode(4);
            llist.insertNode(15);
            llist.insertNode(85);
            
            
            System.out.println("Current Linked List: ");
            printSinglyLinkedList(llist.head, " ");

            System.out.println("");
            
            System.out.println("Sum of Linked List: " + sumLL(llist.head));
            multLL(llist.head,2);
            
  
            
            System.out.println("Given linked list:");
            printSinglyLinkedList(llist.head, " ");
			
            System.out.println("Given linked list:");
            printSinglyLinkedList(llist.head, " ");
            System.out.println("");
            System.out.println("Reversed Linked list:");
            Node llist1 = reverse(llist.head);
            printSinglyLinkedList(llist1, " ");
  
            System.out.println();
            
        scanner.close();
    }

}
