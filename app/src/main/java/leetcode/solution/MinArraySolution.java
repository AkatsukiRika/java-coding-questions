package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 难易度：Easy
 */
public class MinArraySolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return minArray(
            new int[]{2}
        );
    }
    
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}