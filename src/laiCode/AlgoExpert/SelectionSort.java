package laiCode.AlgoExpert;

public class SelectionSort {
    // Time: O(n^2)
    // Space: O(1)
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            swap(i, minIdx, array);
        }
        return array;
    }

    public void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
