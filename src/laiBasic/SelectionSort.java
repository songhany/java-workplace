package laiBasic;

import java.util.Arrays;
// Time O(n^2) |  Space O(1)
public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        // 第 i 轮把第 i 小的 swap到正数第 i 个
        for (int i = 0; i < array.length - 1; i++) {  // 每一轮
            int minIndex = i;  // [0, i) is sorted array
            for (int j = i + 1; j < array.length; j++) {  // 从 i 的下一个元素开始和 array[minIndex] 进行比较
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 7, 4, 1, 3, 8, 6};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));  // 不使用 Array.toString() 只打印 array 的地址
    }
}
