package leetcode.sort;

import leetcode.ISort;

public class BubbleSort implements ISort<Integer> {
    private static final String SORT_TYPE = "冒泡排序";

    @Override
    public Integer[] performSort(Integer[] originArray) {
        if (originArray.length == 0) {
            return new Integer[0];
        }
        if (originArray.length == 1) {
            return new Integer[]{originArray[0]};
        }
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray.length - 1 - i; j++) {
                if (originArray[j] <= originArray[j + 1]) {
                    int temp = originArray[j];
                    originArray[j] = originArray[j + 1];
                    originArray[j + 1] = temp;
                }
            }
        }
        return originArray;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE;
    }
}
