package leetcode.solution;

import leetcode.BaseSolution;

import java.util.HashMap;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 难易度：Easy
 */
public class FindRepeatNumberSolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return findRepeatNumber(
                new int[]{1, 1}
        );
    }

    private final HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int findRepeatNumber(int[] nums) {
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                return num;
            }
            hashMap.put(num, 0);
        }
        return 0;
    }
}
