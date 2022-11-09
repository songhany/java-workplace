package laiCode.dfs;

import java.util.*;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(target, coins, 0, cur, result);
        return result;
    }

    private void dfs(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            dfs(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationsOfCoins sol = new CombinationsOfCoins();
        List<List<Integer>> result = sol.combinations(10, new int[]{1, 5, 10, 25 });
        System.out.println(result);
    }
}
