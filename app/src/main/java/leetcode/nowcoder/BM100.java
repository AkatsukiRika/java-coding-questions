package leetcode.nowcoder;

import leetcode.util.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 牛客网BM100：设计LRU缓存结构
 */
public class BM100 {
    private static final String OPERATOR_SET = "set";
    private static final String OPERATOR_GET = "get";
    private static final String RETURN_VALUE_NULL = "null";
    private static final int LEAST_RECENTLY_USED = 0;

    private final HashMap<Integer, Integer> entryMap = new HashMap<>();

    private final HashMap<Integer, Integer> keyToPriorityMap = new HashMap<>();

    private final HashMap<Integer, Integer> priorityToKeyMap = new HashMap<>();

    private int curMaxPriority = LEAST_RECENTLY_USED;

    private int curMinPriority = LEAST_RECENTLY_USED;

    public ArrayList<String> LRUCache(
        ArrayList<String> operators,
        ArrayList<ArrayList<Integer>> param,
        int capacity
    ) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            ArrayList<Integer> params = param.get(i);

            if (operator.equals(OPERATOR_SET)) {
                int key = params.get(0);
                int value = params.get(1);
                performSet(key, value, capacity);
                result.add(RETURN_VALUE_NULL);
                continue;
            }

            if (operator.equals(OPERATOR_GET)) {
                int getResult = performGet(params.get(0));
                result.add(Integer.valueOf(getResult).toString());
            }
        }

        return result;
    }

    private void performSet(int key, int value, int capacity) {
        if (entryMap.size() >= capacity) {
            removeLeastRecentlyUsed();
        }
        entryMap.put(key, value);
        keyToPriorityMap.put(key, curMaxPriority);
        priorityToKeyMap.put(curMaxPriority, key);
        curMaxPriority = curMaxPriority + 1;
    }

    private int performGet(int key) {
        if (!entryMap.containsKey(key)) {
            return -1;
        }
        int result = entryMap.get(key);
        int priority = keyToPriorityMap.get(key);
        if (priority == curMinPriority) {
            priorityToKeyMap.remove(curMinPriority);
            curMinPriority = curMinPriority + 1;
        }
        keyToPriorityMap.put(key, curMaxPriority);
        priorityToKeyMap.put(curMaxPriority, key);
        curMaxPriority = curMaxPriority + 1;
        return result;
    }

    private void removeLeastRecentlyUsed() {
        if (priorityToKeyMap.containsKey(curMinPriority)) {
            int key = priorityToKeyMap.get(curMinPriority);
            entryMap.remove(key);
            keyToPriorityMap.remove(key);
            priorityToKeyMap.remove(curMinPriority);
            curMinPriority = Collections.min(priorityToKeyMap.keySet());
        }
    }

    /** ソリューションはここまで */

    public void performTest() {
        ArrayList<String> operators = new ArrayList<>(
            List.of("set","set","set","get","set","set","get")
        );

        ArrayList<ArrayList<Integer>> param = new ArrayList<>() {{
            add(new ArrayList<>(List.of(1, 1)));
            add(new ArrayList<>(List.of(2, 2)));
            add(new ArrayList<>(List.of(3, 3)));
            add(new ArrayList<>(List.of(2)));
            add(new ArrayList<>(List.of(4, 4)));
            add(new ArrayList<>(List.of(5, 5)));
            add(new ArrayList<>(List.of(2)));
        }};

        ArrayList<String> result = LRUCache(operators, param, 3);
        Printer.printList(result);
    }
}
