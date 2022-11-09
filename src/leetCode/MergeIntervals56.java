package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {
        // Arrays.deepToString  https://www.geeksforgeeks.org/arrays-deeptostring-in-java-with-example/
        System.out.println(Arrays.deepToString(MergeIntervals56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] i : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < i[0]) {
                merged.add(i);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], i[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
