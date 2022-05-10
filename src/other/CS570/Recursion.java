package other.CS570;

public class Recursion {

	
	/*
	 * 
	 * approach(2) � Recursive adding 

		f(n) = 1     n=1   base case

		f(n) = n + f(n-1)    n>1
		f(n-1) = n-1 + f(n-2)
		
		
		f(n) =  n + f(n-1)+ n-1 + f(n-2)
		
		Memory: each recursive call adds a layer (local variables respective to each function call) onto the stack 
	 			once the base case is reached, the function pops off each layer from the stack and deallocates it
	 */
	public static int fact(int n) {
	    if (n <= 1) // base case
	        return 1;
	    else    
	        return n * fact(n-1);
	}
	
	public static int max(int[] a1, int n) {
		if (n == 1) { //base case
			return a1[0];
		}
	    return Math.max(a1[n-1], max(a1,n-1));
	}
	
	public static int sum(int start, int end) {
	    if (end > start) { //base case
	      return end + sum(start, end - 1);
	    } else {
	      return end;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(fact(4));
		int A[] = {1, 4, 45, 6, -50, 10, 2};
        int n = A.length;
        System.out.println(max(A,n));
        System.out.println(sum(2,6));
	}

	
	
}
