package laiCode.AlgoExpert;

public class HeapSort {
    // Time  O(nlogn)
    // Space O(1)
    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);
        for (int endIdx = array.length - 1; endIdx > 0; endIdx--) {
            swap(0, endIdx, array);
            shiftDown(0, endIdx - 1, array);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            shiftDown(currentIdx, array.length - 1, array);
        }
    }

    public static void shiftDown(int currentIdx, int endIdx, int[] heap) {
        int childOneIdx = currentIdx * 2 + 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx]) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }

            if (heap[idxToSwap] > heap[currentIdx]) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = new int[]{ 8, 5, 2, 9, 5, 6, 3 };

        HeapSort sol = new HeapSort();
        sol.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
