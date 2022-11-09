package other.CS593;

public class GrowArray {
	private int[] p;
	private int size; // the number of elements used
	private int capacity; // the amount of memory

	private void checkGrow() {
		// if the memory needs to grow, double in size
		//TODO: YOU IMPLEMENT THIS
		if (size == capacity) {
			int[] doubledArray = new int[2*capacity];
			for (int i = 0; i < size; i++) {  // copy original array
				doubledArray[i] = p[i];
			}
			p = doubledArray;
			capacity = 2 * capacity;
		}
	}

	public GrowArray(int initialCapacity) {
		p = new int[initialCapacity];
		size = 0;
		capacity = initialCapacity;
	}

	public void addEnd(int v) {
		checkGrow();
		p[size] = v;
		size++;
	}

	public void addStart(int v) {
		checkGrow();
		for (int i = size; i > 0; i--) {  // move every element in array to right by 1
			p[i] = p[i-1];
		}
		p[0] = v;
		size++;
	}

	public void removeStart() {
		for (int i = 0; i < size; i++) {
			p[i] = p[i+1];
		}
		size--;
	}
	
	public void removeEnd() {
		p[size-1] = 0;
		size--;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(p[i]).append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		GrowArray a = new GrowArray(500); // empty list, with 500 elements

		for (int i = 0; i < 500; i++)
			a.addEnd(i); // really fast!

		for (int i = 0; i < 10000000; i++)
			a.addEnd(i); // every time you need to grow, double

		a.addStart(5);
		// 5 0 1 2 3 4 5 6 7 8....   499 0 1 2 3 4 5 6 .... 999999

		for (int i = 0; i < 10000; i++)
			a.removeEnd();

		for (int i = 0; i < 10000; i++)
			a.removeStart();
		
		// 10000 10001 10002 10003 10004 10005 .... .... 998999	
		
//		a.removeEvens();
		System.out.println(a); // use StringBuilder, not String
	}
}
