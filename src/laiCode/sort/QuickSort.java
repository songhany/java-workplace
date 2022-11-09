package laiCode.sort;

import java.util.*;

public class QuickSort {
    public void quickSort(int[] array) {
        if (array == null) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // define pivot and use the pivot to partition
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];

        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound, rightBound);
                leftBound++;
                rightBound--;
            }
        }
        // swap back the pivot element
        swap(array, leftBound, right);
        return leftBound;
    }

    private  int pivotIndex(int left, int right) {
        // sample implementation, pick random element as pivot each time
        return left + (int)(Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        qs.quickSort(a);
        System.out.println(Arrays.toString(a));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

        int b[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        qs.quickSort(b);
        System.out.println(Arrays.toString(b));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        int c[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        qs.quickSort(c);
        System.out.println(Arrays.toString(c));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
