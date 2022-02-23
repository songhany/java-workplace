package laiBasic;

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
        int[] arr = new int[2*3-1];
        for (int a: arr) {
            System.out.println(a);
        }
    }
}
