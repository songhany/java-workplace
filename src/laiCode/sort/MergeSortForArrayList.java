package laiCode.sort;

import java.util.ArrayList;

public class MergeSortForArrayList {
    public ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        if (array == null) {
            return array;
        }
        return mergeSort(array, 0, array.size() - 1);
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> array, int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        if (left == right) {
            result.add(array.get(left));
            return result;
        }
        int mid = left + (right - left) / 2;
        ArrayList<Integer> reLeft = mergeSort(array, left, mid);
        ArrayList<Integer> reRight = mergeSort(array, mid+1, right);
        merge(reLeft, reRight, result);
        return result;
    }

    private void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> result) {
        int l = 0;
        int r = 0;
        while (l < left.size() && r < right.size()) {  // 谁小取谁，取谁移谁
            if (left.get(l) <= right.get(r)) {
                result.add(left.get(l++));
            } else {
                result.add(right.get(r++));
            }
        }
        while (l < left.size()) {
            result.add(left.get(l++));
        }
        while (r < right.size()) {
            result.add(right.get(r++));
        }
    }

    public static void main(String[] args) {
        MergeSortForArrayList ms = new MergeSortForArrayList();
        ArrayList<Integer> arr = new ArrayList<>();
        // 3 1 5 7 9 8 6 4 2 0
        arr.add(3);
        arr.add(1);
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.add(8);
        arr.add(6);
        arr.add(4);
        arr.add(2);
        arr.add(0);
        System.out.println(arr);
        System.out.println(ms.mergeSort(arr));
//        System.out.println(arr);
    }
}
