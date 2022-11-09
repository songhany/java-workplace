package other.CS593;
/*
    HW3A: Quicksort
    Author: Songhan Yu  10470449
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QuickSort {
    private Random r;

    public QuickSort() {
        r = new Random(0);
    }

    public void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        // randomly choose a pivot
        int pivotIndex = left + r.nextInt(right - left + 1);  // generate a r number in [left, right]
        swap(array, pivotIndex, right);  // put the pivot to the rightMost

        // partition
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < array[right]) {  // array[right] is pivot
                i++;
            } else {  // array[i] >= pivot
                swap(array, i, j);
                j--;
            }
        }

        swap(array, i, right);  // put the pivot back to its position

        quickSort(array, left, i - 1);  // recursive quickSort left side of pivot
        quickSort(array, i + 1, right);  // recursive quickSort right side of pivot
    }

    private final void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public void fischerYates(int array[]) {
        int n = array.length;

        for (int i = n - 1; i > 0; i--) {  // Start from the last element and swap one by one. We don't need to run for the first element
            int j = r.nextInt(i+1);  // Pick a r index from 0 to i
            swap(array, i, j);
        }
    }

    public int[] generateArray(int n) {
        int[] millionArray = new int[n];
        for (int i = 0; i < millionArray.length; i++) {  // Generates an array of r numbers from 1 to n
            millionArray[i] = i;
        }
        return millionArray;
    }

    public void test(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != array[i]) {
                System.out.println(i + ": " + array[i]);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        QuickSort qs = new QuickSort();

        // PriorityQueueCompareLogic your code with a large number of elements (10 million)
        System.out.println("========== PriorityQueueCompareLogic your code with a large number of elements ==========");
        int[] millionArray = qs.generateArray(10000000);
        qs.fischerYates(millionArray);  // then uses Fischer-Yates to scramble the array
        //System.out.println("Use FischerYates: " + Arrays.toString(millionArray));
        qs.quickSort(millionArray);
        qs.test(millionArray);
        //System.out.println("Quicksort result: " + Arrays.toString(millionArray));

        // PriorityQueueCompareLogic case
//        System.out.println("========== PriorityQueueCompareLogic case  ==========");
//        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        qs.quickSort(a);
//        System.out.println(Arrays.toString(a));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
//
//        int b[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        qs.quickSort(b);
//        System.out.println(Arrays.toString(b));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//
//        int c[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        qs.quickSort(c);
//        System.out.println(Arrays.toString(c));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//
//        int d[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        qs.quickSort(d);
//        System.out.println(Arrays.toString(d));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
//
//        int e[] = {62, 50, 50, 50, 62};
//        qs.quickSort(e);
//        System.out.println(Arrays.toString(e));  // [50, 50, 50, 62, 62]

        // Open the file hw3.txt
        System.out.println("========== Open file 'hw3.txt' and BigIntegerTest ==========");
        File file = new File("hw3.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            qs.quickSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
