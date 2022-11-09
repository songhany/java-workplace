package other.CS570;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SortAlgorithm {
	

	// inserts the current element in the place its supposed to be
	// O(n^2)
	static void insertion_sort(long[] arr1) {
        int n = arr1.length;
        for (int i = 1; i < n; ++i) {
            int key = (int) arr1[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr1[j] > key) {
                arr1[j + 1] = arr1[j];
                j = j - 1;
            }
            arr1[j + 1] = key;
        }
    }
	

	// selects the min element and places it in the front
	// O(n^2)
	static void selection_sort(long[] arr1) {
        int n = arr1.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr1[j] < arr1[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = (int) arr1[min_idx];
            arr1[min_idx] = arr1[i];
            arr1[i] = temp;
        }
    }
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akhil\\java-workspace\\MyFirstJavaProject\\src\\sort\\array.txt"));
		
		Random r = new Random();
		double start, end;

		int n = 107301;
		long arr1[] = new long[n];
		long arr2[] = new long[n];
		long arr3[] = new long[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = r.nextLong();
			//arr2[i] = Long.parseLong(br.readLine());
			arr2[i] = r.nextLong();
			arr3[i] = r.nextLong();
		}
		
		//Insertion other.CS570.SortAlgorithm
		
		start = System.currentTimeMillis();
		insertion_sort(arr2);
		end = System.currentTimeMillis();
		System.out.println("Insertion other.CS570.SortAlgorithm arr1 (" + n + " elements) took " + (end - start) + " milliseconds");
		
		//Insertion sort runs much more efficiently if the array is already sorted or "close to sorted." 
		//Selection sort always performs O(n) swaps, while insertion sort performs O(n2) swaps in the average and worst case. 
		//Selection sort is preferable if writing to memory is significantly more expensive than reading.
				
		
		
		//Selection other.CS570.SortAlgorithm
		start = System.currentTimeMillis();
		selection_sort(arr3);
		end = System.currentTimeMillis();
		System.out.println("Selection other.CS570.SortAlgorithm arr2 (" + n + " elements) took " + (end - start) + " milliseconds");
		

		
		

		//Arrays. sort() uses two different sorting algorithms. 
		//A modification of Quicksort named dual-pivot Quicksort and a modification of Merge other.CS570.SortAlgorithm named Timesort.
		//Both have a time complexity of O(n log n), where n is the total number of items in the array.

		/*
		Merge other.CS570.SortAlgorithm :
		Worst, Average and Best Case - O(n*log(n))

		Quick other.CS570.SortAlgorithm :
		Worst case - O(n^2)
		Average, Best Case - O(n*log(n))
		

		Merge sort is more efficient and works faster than quick sort in case of larger array size or datasets.
		Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.
		*/
		
		start = System.currentTimeMillis();
		Arrays.sort(arr1);
		end = System.currentTimeMillis();
		System.out.println("Merge other.CS570.SortAlgorithm arr1 (" + n + " elements) took " + (end - start) + " milliseconds");
		
		//Radix other.CS570.SortAlgorithm O(N) algorithm
		//works by taking digit by digit sort starting from least significant digit to most significant digit.
		//Restricted inputs. Radix sort only works when sorting numbers with a fixed number of digits. It won't work for arbitrarily-large numbers.
		//https://www.interviewcake.com/concept/java/radix-sort
		
		
		
		// What is the run time complexity of the following examples? use worst time so BIG O
		// also calculate the a function that represents the number of operations that will take place
		/*
		 * for (int i = 0; i < n ; i ++) {
			for (int j = 0; j <n; j++) {
				count++;
			}	
			}
		 * 
		 * 
		 */
		
		
		
		/*
		 * for (int i = 1; i < n ; i++) {
			for (int j = i; j >= 0; j--) {
				count++
				}	
			}
			
			
		 */
		
		
		/*
		 * for (int j = 0; j < num ; j ++) {
		 * 	for (int i = n; i > 0 ; i= i/2) {
				count++
			}
			}
			
			
		 */
		

		//O(N^2)
		// f(n) = n^2
		
		//O(N^2)
		//summation 2 to n          ( (n)(n+1) /2  )  - 1
		
		
		//O(N log N)
		
		}
	}
	
	
	

