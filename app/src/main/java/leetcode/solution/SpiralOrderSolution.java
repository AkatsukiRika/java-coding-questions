package leetcode.solution;

import leetcode.BaseSolution;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 难易度：Easy
 */
public class SpiralOrderSolution extends BaseSolution<int[]> {
    @Override
    public int[] performSingleTest() {
        return spiralOrder(
            new int[][]{
            }
        );
    }

    enum Status {
        RIGHT, DOWN, LEFT, UP
    }
    
    private final int MAX_DATA_SIZE = 20000;

    private Status status = Status.RIGHT;

    private boolean[][] accessed;
    
    private int rows = 0;
    
    private int columns = 0;
    
    private int curX = 0;
    
    private int curY = 0;
    
    private final int[] result = new int[MAX_DATA_SIZE];
    
    private int resultPtr = 0;

    public int[] spiralOrder(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        columns = matrix[0].length;
        accessed = new boolean[rows][columns];
        
        while (true) {
            accessCurrent(matrix);
            
            if (status == Status.RIGHT) {
                if (checkCanRight()) {
                    curY++;
                    continue;
                } else if (checkCanDown()) {
                    curX++;
                    status = Status.DOWN;
                    continue;
                } else break;
            }
            if (status == Status.DOWN) {
                if (checkCanDown()) {
                    curX++;
                    continue;
                } else if (checkCanLeft()) {
                    curY--;
                    status = Status.LEFT;
                    continue;
                } else break;
            }
            if (status == Status.LEFT) {
                if (checkCanLeft()) {
                    curY--;
                    continue;
                } else if (checkCanUp()) {
                    curX--;
                    status = Status.UP;
                    continue;
                } else break;
            }
            if (status == Status.UP) {
                if (checkCanUp()) {
                    curX--;
                } else if (checkCanRight()) {
                    curY++;
                    status = Status.RIGHT;
                } else break;
            }
        }
        return Arrays.copyOf(result, resultPtr);
    }
    
    private void accessCurrent(int[][] matrix) {
        result[resultPtr++] = matrix[curX][curY];
        accessed[curX][curY] = true;
    }
    
    private boolean checkCanRight() {
        return curY + 1 < columns && !accessed[curX][curY + 1];
    }
    
    private boolean checkCanDown() {
        return curX + 1 < rows && !accessed[curX + 1][curY];
    }
    
    private boolean checkCanLeft() {
        return curY - 1 >= 0 && !accessed[curX][curY - 1];
    }
    
    private boolean checkCanUp() {
        return curX - 1 >= 0 && !accessed[curX - 1][curY];
    }
}