package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 难易度：Easy
 */
public class NumWaysSolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return numWays(44);
    }

    private static final int MOD_VALUE = 1000000007;

    private static final int DATA_SIZE = 2 * 100;

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[DATA_SIZE];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % MOD_VALUE + dp[i - 2] % MOD_VALUE;
            System.out.printf("dp[%d] = %d\n", i, dp[i]);
        }
        return dp[n] % MOD_VALUE;
    }
}
