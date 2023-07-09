package leetcode.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 牛客网BM101：设计LFU缓存结构
 */
public class BM101 {
    private static final int OPERATOR_SET = 1;
    private static final int OPERATOR_GET = 2;

    private final HashMap<Integer, Entry> keyEntryMap = new HashMap<>();

    private int currentStep = 1;

    private final TreeMap<Entry, Integer> entryCountMap = new TreeMap<>((o1, o2) -> {
        if (o1.count < o2.count) {
            return -1;
        } else if (o1.count > o2.count) {
            return 1;
        }
        return 0;
    });

    private int capacity;

    public int[] LFU(int[][] operators, int k) {
        capacity = k;

        int operatorCount = operators.length;
        int[] result = new int[operatorCount];
        int resultPtr = 0;

        for (int[] params : operators) {
            int operator = params[0];
            if (operator == OPERATOR_SET) {
                performSet(params[1], params[2]);
                continue;
            }
            if (operator == OPERATOR_GET) {
                result[resultPtr++] = performGet(params[1]);
            }
            currentStep++;
        }

        return Arrays.copyOf(result, resultPtr);
    }

    private void performSet(int key, int value) {
        if (keyEntryMap.keySet().size() >= capacity) {
            int minCount = entryCountMap.firstEntry().getValue();
            Object[] entries = entryCountMap.keySet().toArray();
            Entry entryToRemove = null;

            for (Object o : entries) {
                Entry entry = (Entry) o;
                if (entry.count != minCount) {
                    break;
                } else if (entryToRemove == null || entry.step < entryToRemove.step) {
                    entryToRemove = entry;
                }
            }

            if (entryToRemove != null) {
                keyEntryMap.remove(entryToRemove.key);
                entryCountMap.remove(entryToRemove);
            }
        }

        Entry entry;
        if (keyEntryMap.containsKey(key)) {
            entry = keyEntryMap.get(key);
            entry.value = value;
            entry.count++;
            entry.step = currentStep;
        } else {
            entry = new Entry(key, value, currentStep);
            keyEntryMap.put(key, entry);
        }
        entryCountMap.put(entry, entry.count);
    }

    private int performGet(int key) {
        if (!keyEntryMap.containsKey(key)) {
            return -1;
        }

        Entry entry = keyEntryMap.get(key);
        entry.count++;
        entry.step = currentStep;
        entryCountMap.put(entry, entry.count);
        return entry.value;
    }
}

class Entry {
    public int key;

    public int value;

    public int count;

    public int step;

    public Entry(int key, int value, int step) {
        this.key = key;
        this.value = value;
        this.count = 1;
        this.step = step;
    }
}
