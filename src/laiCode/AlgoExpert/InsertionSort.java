package laiCode.AlgoExpert;

public class InsertionSort {
/*
    Time:  Best O(n)
           Worst O(n^2)
    Space: O(1)
*/
    public int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return new int[] {};
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j-1]) {
                swap(j, j-1, array);
                j -= 1;
            }
        }
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
