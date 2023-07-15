package leetcode.nowcoder;

/**
 * 牛客网BM63：跳台阶
 */
public class BM63 {
    private static final int MAX_NUMBER = 40;

    public int jumpFloor(int number) {
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }

        int[] dp = new int[MAX_NUMBER + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number];
    }
}
