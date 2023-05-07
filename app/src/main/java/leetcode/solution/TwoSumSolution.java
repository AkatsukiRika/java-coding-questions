package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.util.BigDataHelper;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 难易度：Easy
 */
public class TwoSumSolution extends BaseSolution<int[]> {
    @Override
    public int[] performSingleTest() {
        try {
            long timeBefore = System.currentTimeMillis();
            int[] bigIntegers = BigDataHelper.readIntegersFromFile("big_integers.txt");
            int[] result = twoSum(bigIntegers, 1261980);
            System.out.printf("Data Size: %d, Time Elapsed: %d\n", bigIntegers.length, System.currentTimeMillis() - timeBefore);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        int ptr1 = 0;
        int ptr2 = 1;
        while (ptr1 <= ptr2 && ptr1 < nums.length && ptr2 < nums.length) {
            int num1 = nums[ptr1];
            int num2 = nums[ptr2];
            int numMax = nums[nums.length - 1];

            if (num1 + numMax < target || num1 + num2 > target) {
                ptr1++;
                ptr2 = ptr1 + 1;
            } else if (num1 + num2 < target) {
                if (ptr2 + 1 < nums.length) {
                    ptr2++;
                } else {
                    ptr1++;
                    ptr2 = ptr1 + 1;
                }
            } else {
                return new int[]{num1, num2};
            }
        }
        return null;
    }
}