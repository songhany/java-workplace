package laiBasic;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public int[] mergeTwoSortedArray(int[] array1, int[] array2) {
        // assume array1 and array2 not null or empty
        int [] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        // Both array1 and array2 have element  谁小移谁，移谁取谁
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
        // Post process:
        // array1 still have element
        while (i < array1.length) {  // for linked-list, if (cur1 != null)
            result[k] = array1[i];
            i++;
            k++;
        }
        // array2 still have element
        while (j < array2.length) {  // for linked-list, if (cur2 != null)
            result[k] = array2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] arg) {
        int [] array1= new int[] {2,4,5,7};
        int [] array2 = new int[] {1,3,6,8};
        MergeTwoSortedArray mergeSortPractice = new MergeTwoSortedArray();
        int [] result = mergeSortPractice.mergeTwoSortedArray(array1, array2);
        System.out.println(Arrays.toString(result));
    }
}
