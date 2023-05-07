package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 难易度：Easy
 */
public class SearchSolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return search(
                new int[]{5, 7, 7, 8, 8, 10},
                8
        );
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int index = binarySearch(nums, target, 0, nums.length-1);
        if (index == -1) {
            return 0;
        }
        int result = 0;
        int ptr = 0;
        while (index+ptr < nums.length) {
            if (nums[index+ptr] == target) {
                ptr++;
            } else {
                break;
            }
        }
        result += ptr;

        ptr = 0;
        while (index-ptr >= 0) {
            if (nums[index-ptr] == target) {
                ptr++;
            } else {
                break;
            }
        }
        result += ptr;

        return result-1;
    }

    private int binarySearch(int[] nums, int target, int begin, int end) {
        if (target != nums[begin] && target != nums[end]) {
            if (begin >= end) {
                return -1;
            }
            int mid = (begin + end) / 2;
            if (target > nums[mid]) {
                return binarySearch(nums, target, mid+1, end);
            } else {
                return binarySearch(nums, target, begin, mid);
            }
        } else if (target == nums[begin]) {
            return begin;
        } else {
            return end;
        }
    }
}
