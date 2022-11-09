package laiCode.dfs;

import java.util.*;

public class ValidParenthesesI {
    public List<String> validParentheses(int k) {
        List<String> result = new ArrayList<>();
        char[] cur = new char[2 * k];  // the final string contains 2k characters
        dfs(cur, k, k, 0, result);
        return result;
    }

    private void dfs(char[] cur, int left, int right, int index, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;   // base case need to return, since we cannot go down further
        }
        if (left > 0) {
            cur[index] = '(';
            dfs(cur, left - 1, right, index + 1, result);
        }
        if (right > left) {
            cur[index] = ')';
            dfs(cur, left, right - 1, index + 1, result);
        }
    }

    public static void main(String[] args) {
        ValidParenthesesI sol = new ValidParenthesesI();
        List<String> result = sol.validParentheses(2);
        System.out.println(result);
    }
}
