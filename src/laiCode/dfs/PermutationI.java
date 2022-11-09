package laiCode.dfs;

import java.util.*;

public class PermutationI {
    public List<String> permutation(String set) {  // solution1: DFS solution with Swap-Swap (recommended)
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        dfs(array, 0, result);
        return result;
    }

    private void dfs(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            dfs(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        PermutationI sol = new PermutationI();
        List<String> result = sol.permutation("abc");
        System.out.println(result);
    }


//    public List<String> permutationWithOrder(String set) {  // solution2: maintain the order of all the permutations (not recommended)
//        List<String> result = new ArrayList<>();
//        if (set == null) {
//            return null;
//        }
//        char[] arraySet = set.toCharArray();
//        Arrays.sort(arraySet);
//        boolean[] used = new boolean[arraySet.length];  // record which index has been used in the original arraySet
//        StringBuilder cur = new StringBuilder();
//        helperWithOrder(arraySet, used, cur, result);
//        return result;
//    }
//
//    private void helperWithOrder(char[] array, boolean[] used, StringBuilder cur, List<String> result) {
//        if (cur.length() == array.length) {
//            result.add(cur.toString());
//            return;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                cur.append(array[i]);
//                helperWithOrder(array, used, cur, result);
//                used[i] = false;
//                cur.deleteCharAt(cur.length() - 1);
//            }
//        }
//    }
}
