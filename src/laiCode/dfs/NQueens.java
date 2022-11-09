package laiCode.dfs;

import java.util.*;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, result);
        return result;
    }

    private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n;  i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean valid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens sol = new NQueens();

        System.out.println(sol.nqueens(4));
    }
}
