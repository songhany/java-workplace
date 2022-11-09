package laiCode.dp;

public class LongestAscendingSubarray {
    // Assume: the given array is not null
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int globalMax = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                cur++;
                globalMax = Math.max(globalMax, cur);
            } else {
                cur  = 1;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestAscendingSubarray sol = new LongestAscendingSubarray();
        int longestLength = sol.longest(new int[]{7, 2, 3, 1, 5, 8, 9, 6});
        System.out.println(longestLength);
    }
}

