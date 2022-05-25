package laiBasic;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[j] == 1) {  // red team
                swap(array, i, j);
                i++;
                j++;
            } else if (array[j] == 2) {  // yellow team
                j++;
            } else {  // blue team.   array[j] != 1 && array[j] != 2
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
