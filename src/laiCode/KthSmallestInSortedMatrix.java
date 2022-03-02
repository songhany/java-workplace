package laiCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
* Assumptions:
* 1) matrix is not null, N * M where N > 0 and M > 0
* 2) k > 0 and k <= N * M
*
* Time: O(k logk)
* Space: O(mn + k) where m is the row of matrix, n is the column of matrix
* */
public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        // BFS, need a minheap on the value of each cells
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        // all the generated cells will be marked true, to avoid being generated more than once
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        // iterate k-1 rounds, and BFS the smallest k-1 cells
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            /* The neighbor cell will be inserted back to the minheap only if
            *  1. it is not out of boundary
            *  2. it has not been generated before
            * Because for each cell it could be generated twice.
            * */
            if (cur.row + 1 < rows && !visited[cur.row+1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    static class Cell {
        int row;
        int column;
        int value;

        Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix solution = new KthSmallestInSortedMatrix();

        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }
}
