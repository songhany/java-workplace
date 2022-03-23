package other.sorting;

public class ThreeNumberSort {
    // Time: O(n)
    // Space: O(1) - where n is the length of array
    public int[] threeNumberSort(int[] array, int[] order) {
        int[] valueCounts = new int[]{0, 0, 0};
        for (int element: array) {
            int orderIdx = getIndex(order, element);
            valueCounts[orderIdx] += 1;
        }

        for (int i = 0; i < 3; i++) {
            int value = order[i];
            int count = valueCounts[i];

            int numElementsBefore = getSum(valueCounts, i);
            for (int n = 0; n < count; n++) {
                int currentIdx = numElementsBefore + n;
                array[currentIdx] = value;
            }
        }
        return array;
    }

    public int getIndex(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int getSum(int[] array, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = new int[]{ 1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[]{ 0, 1, -1};

        ThreeNumberSort sol = new ThreeNumberSort();
        sol.threeNumberSort(arr, order);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
