package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 难易度：Medium
 */
public class FindNumberIn2DArraySolution extends BaseSolution<Boolean> {
    @Override
    public Boolean performSingleTest() {
        return findNumberIn2DArray(
            new int[][]{
                    {},
                    {}
            },
            5
        );
    }

    public Boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] curLine : matrix) {
            if (curLine.length == 0) {
                return false;
            }

            int lineMin = curLine[0];
            int lineMax = curLine[curLine.length - 1];
            if (target >= lineMin && target <= lineMax) {
                boolean searchResult = binarySearch(curLine, 0, curLine.length - 1, target);
                if (searchResult) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean binarySearch(int[] line, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (line[mid] == target) {
            return true;
        }
        if (left >= right) {
            return false;
        }
        if (line[mid] < target) {
            return binarySearch(line, mid + 1, right, target);
        } else {
            return binarySearch(line, 0, mid, target);
        }
    }
}
