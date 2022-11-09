package other.CS570;

public class BinaryTree {
	
	    static class Node {
	        public int val;
	        public Node left;
	        public Node right;

	        public Node(int val) {
	            this.val = val;
	            this.left = null;
	            this.right = null;
	        }
	    }
	    
	    // instance variable of binary tree class
	    public Node root;

	    // constructor for initialise the root to null BYDEFAULT
	    public BinaryTree() {
	        this.root = null;
	    }

	    // method to check the given tree is Binary search tree or not
	    public boolean isBSTOrNot() {
	        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }

		private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
			// check for root is not null or not
			if (root == null) {
				return true;
			}
			// check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
			if(root.val >= minValue && root.val <= maxValue && isBSTOrNot(root.left, minValue, root.val) && isBSTOrNot(root.right, root.val, maxValue)){
				return true;
			}
			return false;
		}

	    //checks every node to see if there is a target value
	    public boolean findValue(Node root, int target) {
	    	if (root == null) {
	    		return false;
	    	}
	    	if(root.val == target) {
	    		return true;
	    	}
	    	boolean right = findValue(root.right,target);
	    	boolean left = findValue(root.left,target);
	    	return right || left;
	    }
	    
	    // returns the sum of the nodes in the tree
	    public int addTree(Node root) {
	    	if (root == null) {
	    		return 0;
	    	}
	    	return addTree(root.left) + addTree(root.right) + root.val;
	    }
	    
	    // returns the number of nodes in the tree
	    public int size(Node root) {
	    	if (root == null) {
	    		return 0;
	    	}
	    	return size(root.right) + size(root.left) + 1;
	    	
	    }

	    /*
	     * Algorithm Inorder(tree)
   			1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   			2. Visit the root.
   			3. Traverse the right subtree, i.e., call Inorder(right-subtree)
	     */
	    void inorder(Node node) {
	        if (node == null)
	            return;
	 
	       
	        inorder(node.left);
	        System.out.print(node.val + " ");
	        inorder(node.right);
	    }

	    public static void main(String[] args) {
	        // Creating the object of other.CS570.BinaryTree class
	        BinaryTree bt = new BinaryTree();
	        bt.root= new Node(100);
	        bt.root.left= new Node(90);
	        bt.root.right= new Node(110);
	        bt.root.left.left= new Node(80);
	        bt.root.left.right= new Node(95);

	        bt.root.right.right= new Node(120);
	        bt.root.right.left= new Node(105);
	        
	        
	  //                      100
	  //            90                       110
	  //      80         95         105               120
	        System.out.println("BST: " + bt.isBSTOrNot());
	        System.out.println("Sum of Tree: " + bt.addTree(bt.root));
	        System.out.println("Size: " + bt.size(bt.root));
	        System.out.println("Find Value: " + bt.findValue(bt.root,120));
	        System.out.print("InOrder Traversal: ");
	        bt.inorder(bt.root);
	        //prints the proper order of binary search tree
	    }

}
