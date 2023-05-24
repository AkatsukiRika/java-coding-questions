package leetcode.sort;

import leetcode.ISort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements ISort {
    private static final String SORT_TYPE = "桶排序";

    private static final int BUCKET_COUNT = 5;

    private int minValue = Integer.MAX_VALUE;

    private int maxValue = Integer.MIN_VALUE;

    private static class Bucket {
        public int minValue;

        public int maxValue;

        public List<Integer> elements;

        public Bucket(int minValue, int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.elements = new ArrayList<>();
        }
    }

    private final List<Bucket> buckets = new ArrayList<>();

    @Override
    public int[] performSort(int[] originArray) {
        getMinAndMaxValue(originArray);
        boolean[] access = new boolean[originArray.length];
        int diff = (maxValue - minValue) / BUCKET_COUNT;
        for (int i = 0; i < BUCKET_COUNT; i++) {
            Bucket bucket = new Bucket(
                i == BUCKET_COUNT - 1 ? minValue : maxValue - (i + 1) * diff,
                maxValue - i * diff
            );
            for (int j = 0; j < originArray.length; j++) {
                if (!access[j] && originArray[j] >= bucket.minValue && originArray[j] <= bucket.maxValue) {
                    access[j] = true;
                    bucket.elements.add(originArray[j]);
                }
            }
            buckets.add(bucket);
        }

        List<int[]> sortedArrays = new ArrayList<>();
        SelectionSort selectionSort = new SelectionSort();
        for (Bucket bucket : buckets) {
            int[] array = bucket.elements.stream().mapToInt(Integer::intValue).toArray();
            sortedArrays.add(selectionSort.performSort(array));
        }

        MergeSort mergeSort = new MergeSort();
        while (sortedArrays.size() > 1) {
            List<int[]> newSortedArrays = new ArrayList<>();
            for (int i = 0; i < sortedArrays.size(); i += 2) {
                if (i + 1 < sortedArrays.size()) {
                    int[] mergeResult = mergeSort.mergeTwoArrays(sortedArrays.get(i), sortedArrays.get(i + 1));
                    newSortedArrays.add(mergeResult);
                } else {
                    newSortedArrays.add(sortedArrays.get(i));
                }
            }
            sortedArrays.clear();
            sortedArrays.addAll(newSortedArrays);
        }

        return sortedArrays.get(0);
    }

    private void getMinAndMaxValue(int[] originArray) {
        for (int value : originArray) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }
    }

    @Override
    public String getSortType() {
        return SORT_TYPE;
    }
}
