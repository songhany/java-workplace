package laiCode.dfs;

import java.util.*;

public class Subset {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    // at each level, determine the character at the position "index" to be picked or not
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // terminate condition
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        // 1. not pick the character of index
        helper(set, sb, index+1, result);

        // 2. pick the character at index
        sb.append(set[index]);
        helper(set, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);  // remove the added character when backtracking to the previous level
    }

    public static void main(String[] args) {
        Subset obj = new Subset();
        List<String> result = obj.subSets("abc");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
