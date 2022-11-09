package laiBasic;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        return mergeTwoSortedArray(leftResult, rightResult);
    }

    public int[] mergeTwoSortedArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        while(i < array1.length) {
            result[k] = array1[i];
            i++;
            k++;
        }
        while(j < array2.length) {
            result[k] = array2[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int [] array = {5, 2, 7, 4, 1, 3, 8, 6};
        array = mergeSort.mergeSort(array);
        System.out.println((Arrays.toString(array)));
    }
}















