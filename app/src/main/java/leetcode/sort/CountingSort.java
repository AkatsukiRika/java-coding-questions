package leetcode.sort;

import leetcode.ISort;

import java.util.*;

public class CountingSort implements ISort<Float> {
    private static final String SORT_TYPE = "计数排序";

    private float minValue = Float.MAX_VALUE;

    private float maxValue = Float.MIN_VALUE;

    private static class CountInfo {
        public int key;

        public List<Float> valueList;

        public boolean needSort = false;

        public CountInfo(int key) {
            this.key = key;
            this.valueList = new ArrayList<>();
        }

        public void sortValueList() {
            SelectionSortFloat selectionSort = new SelectionSortFloat();
            Float[] sortResult = selectionSort.performSort(valueList.toArray(Float[]::new));
            valueList.clear();
            valueList.addAll(Arrays.asList(sortResult));
        }
    }

    private final TreeMap<Integer, CountInfo> countMap = new TreeMap<>();

    @Override
    public Float[] performSort(Float[] originArray) {
        getMinAndMaxValue(originArray);
        buildCountMap();
        for (float value : originArray) {
            CountInfo countInfo = countMap.get((int)value);
            assert(countInfo != null);
            if (!countInfo.valueList.isEmpty()) {
                countInfo.needSort = countInfo.needSort || !(value == countInfo.valueList.get(0));
                countInfo.valueList.add(value);
                if (countInfo.needSort) {
                    countInfo.sortValueList();
                }
            } else {
                countInfo.valueList.add(value);
            }
        }

        Float[] resultArray = new Float[originArray.length];
        int ptr = 0;
        for (int key : countMap.descendingKeySet()) {
            CountInfo countInfo = countMap.get(key);
            for (float value : countInfo.valueList) {
                resultArray[ptr++] = value;
            }
        }
        return resultArray;
    }

    @Override
    public String getSortType() {
        return SORT_TYPE;
    }

    private void getMinAndMaxValue(Float[] originArray) {
        for (float value : originArray) {
            if (value <= minValue) {
                minValue = value;
            }
            if (value >= maxValue) {
                maxValue = value;
            }
        }
    }

    private void buildCountMap() {
        for (int i = (int)maxValue; i >= (int)minValue; i--) {
            CountInfo countInfo = new CountInfo(i);
            countMap.put(i, countInfo);
        }
    }
}
