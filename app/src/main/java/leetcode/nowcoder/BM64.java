package leetcode.nowcoder;

/**
 * 牛客网BM64：最小花费爬楼梯
 */
public class BM64 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[][] dp = new int[2][cost.length + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j <= i) {
                    dp[i][j] = 0;
                } else if ((j - i == 1 || j - i == 2) && i < cost.length) {
                    dp[i][j] = cost[i];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 3; j < dp[i].length; j++) {
                dp[i][j] = Math.min(
                    dp[i][j - 1] + cost[j - 1],
                    dp[i][j - 2] + cost[j - 2]
                );
            }
        }

        return Math.min(dp[0][cost.length], dp[1][cost.length]);
    }
}