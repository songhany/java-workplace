package laiCodeBasic;

public class test {
    public static int minIndex(int[] array, int i) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }

        int minValue = array[0];
        for (int j = i; j<array.length; j++) {
            System.out.print(minValue + " ");
            System.out.print(array[j]);
            System.out.println();
            if (minValue > array[j]) {
                minValue = array[j];
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(minIndex(new int[]{5,4,3,2,1}, 1));
    }
}
