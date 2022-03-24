package other.sorting;

import java.util.ArrayList;
import java.util.List;

/*
An inversion occurs if for any valid indices i and j,  i < j  and  array[i] > array[j]
对于 unsorted array = 【3， 4， 1， 2】有哪些元素可以swap 使得前面的大元素和后面的小元素交换变为 ascending sorted 的，
the following pairs of indices represent inversions: [0, 2], [0, 3], [1, 2], [1, 3]
so there are 4 inversions, return 4

* */
public class CountInversions {   // https://www.algoexpert.io/questions/Count%20Inversions
    //
    // Time   O(nlogn)
    // Space  O(n) where n is the length of the array
    public int countInversions(int[] array) {
        return countSubArrayInversions(array, 0, array.length);
    }

    public int countSubArrayInversions(int[] array, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }

        int middle = start + (end - start) / 2;
        int leftInversions = countSubArrayInversions(array, start, middle);
        int rightInversions = countSubArrayInversions(array, middle, end);
        int mergedArrayInversions = mergeSortAndCountInversions(array, start, middle, end);
        return leftInversions + rightInversions + mergedArrayInversions;
    }

    public int mergeSortAndCountInversions(int[] array, int start, int middle, int end) {
        List<Integer> sortedArray = new ArrayList<Integer>();
        int left = start;
        int right = middle;
        int inversions = 0;

        while (left < middle && right < end) {
            if (array[left] <= array[right]) {
                sortedArray.add(array[left]);
                left += 1;
            } else {
                inversions += middle - left;
                sortedArray.add(array[right]);
                right += 1;
            }
        }

        for (int idx = left; idx < middle; idx++) {
            sortedArray.add(array[idx]);
        }

        for (int idx = right; idx < end; idx++) {
            sortedArray.add(array[idx]);
        }

        for (int idx = 0; idx < sortedArray.size(); idx++) {
            int num = sortedArray.get(idx);
            array[start + idx] = num;
        }
        return inversions;
    }

    public static void main(String[] args) {
        CountInversions sol = new CountInversions();
        System.out.println(sol.countInversions(new int[]{2, 3, 3, 1, 9, 5, 6}));  // 5
    }
}
