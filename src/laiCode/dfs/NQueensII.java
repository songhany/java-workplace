package laiCode.dfs;

import java.util.*;

public class NQueensII {
    public List<List<Integer>> nqueensII(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int[] cur = new int[n];                              // cur will be a list a size n, cur[i] is the column number where the queen in row i positioned
        boolean[] usedColumns = new boolean[n];              // record on which columns there is already a queen
        boolean[] usedDiagonals = new boolean[2 * n - 1];    // record on which diagonal lines, there is already a queen
        boolean[] usedRevDiagonal = new boolean[2 * n - 1];  // record on which reverse diagonal lines, there is already a queen
        helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonal);
        return result;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        if (row == n) {  // base case:  when for all the rows we know where the queen is positioned
            result.add(toList(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
                mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                cur[row] = i;
                helper(n, row + 1, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
                unMark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }

    private boolean valid(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        return !usedColumns[column] && !usedDiagonals[column + row] && !usedRevDiagonals[column - row + n - 1];
    }

    private void mark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        usedColumns[column] = true;
        usedDiagonals[column + row] = true;
        usedRevDiagonals[column - row + n - 1] = true;
    }

    private void unMark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        usedColumns[column] = false;
        usedDiagonals[column + row] = false;
        usedRevDiagonals[column - row + n - 1] = false;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num: array) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        NQueensII sol = new NQueensII();
        System.out.println(sol.nqueensII(4));
    }
}
