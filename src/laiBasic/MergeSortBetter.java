package laiBasic;

import java.util.*;

public class MergeSortBetter {  // better way
    /*          divide      merge
        Time:   O(n)   +  O(n*logn) = O(n*logn)
        Space: O(logn) +   O(n)     = O(n)
    */
    public int[] mergeSort(int[] array) {
        if (array == null) {  // check null array first
            return array;
        }

        int[] helper = new int[array.length];   // allocate helper array to help merge step, so that we guarantee no more than O(n) space is used. The space complexity is O(n) is this case.
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort( int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge( int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {          // copy the content to helper array and we will merge from the helper array
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }

        // if we still have some elements at left side, we need to copy them
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }

        // if there are some elements at right side, we do not need to copy them
        // because they are already in their position
    }


    public static void main(String[] args) {
        MergeSortBetter solution = new MergeSortBetter();

        // BigIntegerTest case to cover possible situation
        int[] array = null;
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[0];
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{ 1, 2, 3, 4 };
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{ 4, 3, 2, 1 };
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{ 2, 4, 1, 5, 3 };
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
