package laiBasic;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private Random random = new Random();

    public void quickSort(int[] array) {
        // corner case
        if (array == null || array.length <= 1) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int left, int right) {  // [left, right]
        // base case
        if (left >= right) {
            return;
        }

        // 1. randomly choose a pivot
        //    random.nextInt(x) -> a random integer [0, x)
        //    ※ Goal: a random integer in [left, right]
        //             left = 2,  right = 5,  generate a random number in [2, 5]
        //      [2, 5] -> 2 + [0, 4)  left + random.nextInt(right - left + 1):  2 + random.nextInt(4)
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(array, pivotIndex, right);

        // 2. partition 分组过程
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < array[right]) {  // smaller than pivot
                i++;
            } else {  // larger than or equal to pivot
                swap(array, i, j);
                j--;
            }
        }

        // 3. put the pivot back
        swap(array, i, right);

        // 4. recursive rule (subproblem)
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {1, 9, 8, 5, 3};
        QuickSort qs = new QuickSort();
        qs.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
