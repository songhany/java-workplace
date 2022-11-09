package laiCode.dp;

public class MaxProductCuttingRope {
    public int getMaxProductWithDFS(int n) {
        if (n <= 1) {   // base case
            return 0;
        }
        int maxProduct = 0;
        for (int i = 1; i < n; i++) {   // i = meters of rope to cut off
            int best = Math.max(n - i, getMaxProductWithDFS(n - i));
            //                    |                     |
            //     (no cut) rope remains        (cut) sub-problem
            maxProduct = Math.max(maxProduct, best * i);
            //                                     |
            //                                left * right
        }
        return maxProduct;
    }

    public int getMaxProductWithDP(int n) {
        int[] M = new int[n + 1];   // chart
        // base case
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= n; i++) {   // n meters. Linear Scan for loop -->
            int curMax = 0;
            for (int j = 1; j < i; j++) {   // Look back <--
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
            }
            M[i] = curMax;
        }
        return M[n];
    }

    public static void main(String[] args) {
        MaxProductCuttingRope sol = new MaxProductCuttingRope();
        int maxProduct = sol.getMaxProductWithDFS(4);
        System.out.println(maxProduct);

        maxProduct = sol.getMaxProductWithDP(4);
        System.out.println(maxProduct);
    }
}
