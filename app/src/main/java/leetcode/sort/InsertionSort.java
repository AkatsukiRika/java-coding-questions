package leetcode.sort;

import leetcode.ISort;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertionSort implements ISort<Integer> {
    private static final String SORT_TYPE = "插入排序";

    @Override
    public Integer[] performSort(Integer[] originArray) {
        if (originArray.length <= 1) {
            return originArray;
        }

        LinkedList<Integer> originList = new LinkedList<>(Arrays.asList(originArray));
        for (int i = 1; i < originList.size(); i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (originList.get(i) < originList.get(j)) {
                    break;
                }
            }
            int nodeToInsert = originList.get(i);
            originList.remove(i);
            originList.add(j + 1, nodeToInsert);
        }

        Integer[] resultArray = new Integer[originList.size()];
        int ptr = 0;
        for (int value : originList) {
            resultArray[ptr++] = value;
        }
        return resultArray;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE;
    }
}
