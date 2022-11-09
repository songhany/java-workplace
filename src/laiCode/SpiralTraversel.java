package laiCode;

import java.util.*;

public class SpiralTraversel {
    // Method1: Recursive Traversal
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        recursiveTraverse(matrix, 0, matrix.length, list);
        return list;
    }

    private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {  // offset 偏移   size 边长
        if (size == 0) {
            return;
        }
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        for (int i = 0; i < size - 1; i++) {   // upper row
            result.add(matrix[offset][offset + i]);
            System.out.println(result);
        }
        for (int i = 0; i < size - 1; i++) {   // right column
            result.add(matrix[offset + i][offset + size - 1]);
            System.out.println(result);
        }
        for (int i = size - 1; i >= 1; i--) {  // bottom row
            result.add((matrix[offset + size - 1][offset + i]));
            System.out.println(result);
        }
        for (int i = size - 1; i >= 1; i--) {  // left column
            result.add(matrix[offset + i][offset]);
            System.out.println(result);
        }
        recursiveTraverse(matrix, offset + 1, size - 2, result);
    }


    public List<Integer> spiralII(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            for (int i = start; i <= end; i++) {
                list.add(matrix[start][i]);
            }
            for (int i = start + 1; i <= end - 1; i++) {
                list.add(matrix[i][end]);
            }
            for (int i = end; i >= start; i--) {
                list.add(matrix[end][i]);
            }
            for (int i = end - 1; i >= start + 1; i--) {
                list.add(matrix[i][start]);
            }
            start++;
            end--;
        }
        // if at least we have 1 element left, we need to traverse it as well
        if (start == end) {
            list.add(matrix[start][end]);
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralTraversel solution = new SpiralTraversel();

        /*
            1 2 3
            4 5 6
            7 8 9
        */
        System.out.println(solution.spiral(new int[][]{{1,2,3},{4,5,6},{7,8,9}})); // [1, 2, 3, 6, 9, 8, 7, 4, 5]

        /*
            1  2  3  4  5
            16 17 18 19 6
            15 24 25 20 7
            14 23 22 21 8
            13 12 11 10 9
        */
        System.out.println(solution.spiral(new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}}));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]

        System.out.println(solution.spiralII(new int[][]{{1,2,3},{4,5,6},{7,8,9}})); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(solution.spiralII(new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}}));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
    }
}
