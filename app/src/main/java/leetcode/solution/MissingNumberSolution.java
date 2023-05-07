package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 难易度：Easy
 */
public class MissingNumberSolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return missingNumber(
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}
        );
    }

    public int missingNumber(int[] nums) {
        for (int ptr = 1; ptr < nums.length; ptr++) {
            if (nums[ptr] - nums[ptr-1] > 1) {
                return nums[ptr] - 1;
            }
        }
        return nums[0] == 0 ? nums.length : 0;
    }
}
