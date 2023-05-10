package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 难易度：Easy
 */
public class PrintNumbersSolution extends BaseSolution<int[]> {
    @Override
    public int[] performSingleTest() {
        long beginTime = System.currentTimeMillis();
        int[] result = printNumbers(4);
        System.out.printf("Time Elapsed=%d\n", System.currentTimeMillis() - beginTime);
        return result;
    }

    public int[] printNumbers(int n) {
        int size = ((int) Math.pow(10, n)) - 1;
        int[] result = new int[size];
        int count = 1;
        int ptr = 0;
        while (count <= size) {
            result[ptr++] = count++;
        }
        return result;
    }
}
