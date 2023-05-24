package leetcode.sort;

import leetcode.ISort;

import java.util.*;

public class MergeSort implements ISort {
    private static final String SORT_TYPE = "归并排序";

    private static class BisectInfo {
        public int beginIndex;

        public int endIndex;

        public int layer;

        public BisectInfo(int beginIndex, int endIndex, int layer) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.layer = layer;
        }

        public BisectInfo copy() {
            return new BisectInfo(this.beginIndex, this.endIndex, this.layer);
        }
    }

    private final Map<Integer, List<BisectInfo>> bisectInfoMap = new TreeMap<>();

    @Override
    public int[] performSort(int[] originArray) {
        if (originArray.length <= 1) {
            return originArray;
        }
        doBisect(
            new BisectInfo(0, originArray.length - 1, 0)
        );
        ArrayList<int[]> sortedList = new ArrayList<>();
        for (int i = bisectInfoMap.size() - 1; i >= 0; i--) {
            List<BisectInfo> bisectInfoList = bisectInfoMap.get(i);
            ArrayList<int[]> newSortedList = new ArrayList<>();
            for (int j = 0; j < sortedList.size(); j += 2) {
                if (j + 1 < sortedList.size()) {
                    newSortedList.add(mergeTwoArrays(sortedList.get(j), sortedList.get(j + 1)));
                }
            }
            for (BisectInfo info : bisectInfoList) {
                int length = info.endIndex - info.beginIndex;
                if (length <= 1) {
                    newSortedList.add(doSort(originArray, info));
                }
            }
            sortedList.clear();
            sortedList.addAll(newSortedList);
            if (sortedList.size() == 1) {
                break;
            }
        }
        return sortedList.get(0);
    }

    private int[] doSort(int[] originArray, BisectInfo bisectInfo) {
        int length = bisectInfo.endIndex - bisectInfo.beginIndex;
        int[] array = Arrays.copyOfRange(originArray, bisectInfo.beginIndex, bisectInfo.endIndex + 1);
        if (length == 0) {
            return array;
        }
        if (length == 1) {
            if (array[1] > array[0]) {
                int temp = array[1];
                array[1] = array[0];
                array[0] = temp;
            }
            return array;
        }
        return null;
    }

    private void doBisect(BisectInfo bisectInfo) {
        if (bisectInfoMap.containsKey(bisectInfo.layer)) {
            bisectInfoMap.get(bisectInfo.layer).add(bisectInfo.copy());
        } else {
            List<BisectInfo> bisectInfoList = new ArrayList<>();
            bisectInfoList.add(bisectInfo.copy());
            bisectInfoMap.put(bisectInfo.layer, bisectInfoList);
        }
        if (bisectInfo.endIndex - bisectInfo.beginIndex <= 1) {
            return;
        }
        int beginIndex = bisectInfo.beginIndex;
        int endIndex = bisectInfo.endIndex;
        int mid = (beginIndex + endIndex) / 2;
        bisectInfo.layer++;
        bisectInfo.beginIndex = beginIndex;
        bisectInfo.endIndex = mid;
        doBisect(bisectInfo);

        bisectInfo.beginIndex = mid + 1;
        bisectInfo.endIndex = endIndex;
        doBisect(bisectInfo);
        bisectInfo.layer--;
    }

    public int[] mergeTwoArrays(int[] array1, int[] array2) {
        if (array1.length == 0) {
            return array2;
        }
        if (array2.length == 0) {
            return array1;
        }

        int[] result = new int[array1.length + array2.length];
        int ptr1 = 0;
        int ptr2 = 0;
        int resultPtr = 0;
        while (ptr1 < array1.length && ptr2 < array2.length) {
            if (array1[ptr1] >= array2[ptr2]) {
                result[resultPtr++] = array1[ptr1++];
            } else {
                result[resultPtr++] = array2[ptr2++];
            }
        }
        while (ptr1 < array1.length) {
            result[resultPtr++] = array1[ptr1++];
        }
        while (ptr2 < array2.length) {
            result[resultPtr++] = array2[ptr2++];
        }
        return result;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE;
    }
}
