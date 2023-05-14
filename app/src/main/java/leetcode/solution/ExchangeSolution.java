package leetcode.solution;

import leetcode.BaseSolution;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 难易度：Easy
 */
public class ExchangeSolution extends BaseSolution<int[]> {
    @Override
    public int[] performSingleTest() {
        return exchange(
            new int[]{}
        );
    }

    public static final int DATA_SIZE = 100000;

    private final int[] oddNumbers = new int[DATA_SIZE];    // 奇数

    private int oddPtr = 0;

    private final int[] evenNumbers = new int[DATA_SIZE];       // 偶数

    private int evenPtr = 0;

    public int[] exchange(int[] nums) {
        for (int num : nums) {
            if (num % 2 == 0) {
                evenNumbers[evenPtr++] = num;
            } else {
                oddNumbers[oddPtr++] = num;
            }
        }
        int[] result = new int[DATA_SIZE];
        System.arraycopy(oddNumbers, 0, result, 0, oddPtr);
        System.arraycopy(evenNumbers, 0, result, oddPtr, evenPtr);
        return Arrays.copyOf(result, oddPtr + evenPtr);
    }
}
