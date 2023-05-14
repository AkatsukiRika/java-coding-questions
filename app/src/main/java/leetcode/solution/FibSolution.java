package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 难易度：Easy
 */
public class FibSolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return fib(95);
    }

    private static final int MOD_VALUE = 1000000007;

    private static final int DATA_SIZE = 200;

    public int fib(int n) {
        long[] fibArray = new long[DATA_SIZE];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % MOD_VALUE;
        }
        return (int)(fibArray[n] % MOD_VALUE);
    }
}
