package other.CS570;

public class MaxHeap { 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    // Constructor to initialize an 
    // empty max heap with given maximum 
    // capacity. 
    public MaxHeap(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  
    // Returns position of parent 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    // Returns true of given node is leaf 
    //all leaves are in the second half of the array
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
    // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
    
    //making sure the subtree does not violate max heap properties
    private void maxHeapify(int pos) {
        if (isLeaf(pos)) 
            return; 
        // if either child is greater than the parent
        if (Heap[pos] < Heap[leftChild(pos)] ||  Heap[pos] < Heap[rightChild(pos)]) {
        	
        	//check which child is greater and swap that child with the parent 
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } else {
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
   
    //Inserting a new key takes O(Log n) time. 
    //We add a new key at the end of the tree. 
    //If the new key is smaller than its parent, then we don�t need to do anything. 
    //Otherwise, we need to traverse up to fix the violated heap property.
    public void add(int element) {
        Heap[++size] = element; 
  
        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void display() {
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    // Remove an element from max heap 
    public int poll() {
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
  
    public static void main(String[] arg) {
        System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(20); 
        maxHeap.add(15); 
        maxHeap.add(13); 
        maxHeap.add(7); 
        maxHeap.add(5); 
        maxHeap.add(52); 
        maxHeap.add(23); 
        maxHeap.add(16); 
        maxHeap.add(9); 
        maxHeap.add(21); 
  
        maxHeap.display(); 
        System.out.println("The max val is " + maxHeap.poll()); 
    } 
}