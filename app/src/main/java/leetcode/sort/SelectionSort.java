package leetcode.sort;

import leetcode.ISort;

public class SelectionSort implements ISort {
    private static final String SORT_TYPE_NAME = "选择排序";
    
    @Override
    public int[] performSort(int[] originArray) {
        if (originArray.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < originArray.length - 1; i++) {
            for (int j = i; j < originArray.length; j++) {
                if (originArray[j] > originArray[i]) {
                    int temp = originArray[j];
                    originArray[j] = originArray[i];
                    originArray[i] = temp;
                }
            }
        }
        return originArray;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE_NAME;
    }
}