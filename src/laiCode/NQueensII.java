package laiCode;

import java.util.*;

public class NQueensII {
    public List<List<Integer>> nqueensII(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] cur = new int[n];

        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiagonals = new boolean[2 * n - 1];
        boolean[] usedRevDiagonal = new boolean[2 * n - 1];
        helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonal);
        return result;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        if (row == n) {
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
        usedColumns[column] = true;
        usedDiagonals[column + row] = true;
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
        NQueensII solution = new NQueensII();

        System.out.println(solution.nqueensII(8));
    }
}
