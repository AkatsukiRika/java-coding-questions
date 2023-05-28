package leetcode.sort;

import leetcode.ISort;

import java.util.Arrays;
import java.util.Collections;

public class LibrarySort<T> implements ISort<T> {
    private static final String SORT_TYPE_NAME = "库函数排序";

    @Override
    public T[] performSort(T[] originArray) {
        Arrays.sort(originArray, Collections.reverseOrder());
        return originArray;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE_NAME;
    }
}
