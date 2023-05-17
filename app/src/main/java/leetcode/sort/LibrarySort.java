package leetcode.sort;

import leetcode.ISort;

import java.util.Arrays;
import java.util.Collections;

public class LibrarySort implements ISort {
    private static final String SORT_TYPE_NAME = "库函数排序";

    @Override
    public int[] performSort(int[] originArray) {
        Integer[] integers = new Integer[originArray.length];
        int ptr = 0;
        for (int value : originArray) {
            integers[ptr++] = value;
        }
        Arrays.sort(integers, Collections.reverseOrder());

        ptr = 0;
        for (Integer value : integers) {
            originArray[ptr++] = value;
        }
        return originArray;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE_NAME;
    }
}
