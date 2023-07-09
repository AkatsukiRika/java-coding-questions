package leetcode.nowcoder;

import leetcode.model.ListNodeWithPrev;

import java.util.HashMap;

/**
 * 牛客网BM100：设计LRU缓存结构
 */
public class BM100 {
    private final int capacity;

    private int count = 0;

    private ListNodeWithPrev head;

    private ListNodeWithPrev tail;

    private final HashMap<Integer, ListNodeWithPrev> hashMap;

    public BM100(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        int value = (hashMap.get(key) == null) ? -1 : hashMap.get(key).val;
        removeByKey(key);
        addToTail(key, value);
        return value;
    }

    public void set(int key, int value) {
        if (count < capacity) {
            addToTail(key, value);
            count++;
        } else {
            removeHead();
            addToTail(key, value);
        }
    }

    private void removeHead() {
        if (head == null) {
            return;
        }
        int oldHeadKey = head.key;
        ListNodeWithPrev prevNode = head.prev;
        if (prevNode == null) {
            // head和tail均指向链表里的唯一节点
            head = null;
            tail = null;
        } else {
            prevNode.next = null;
            head = prevNode;
        }
        hashMap.remove(oldHeadKey);
    }

    private void removeTail() {
        if (tail == null) {
            return;
        }
        int oldTailKey = tail.key;
        ListNodeWithPrev nextNode = tail.next;
        if (nextNode == null) {
            // head和tail均指向链表里的唯一节点
            head = null;
            tail = null;
        } else {
            nextNode.prev = null;
            tail = nextNode;
        }
        hashMap.remove(oldTailKey);
    }

    private void removeByKey(int key) {
        ListNodeWithPrev node = hashMap.get(key);
        if (node == head) {
            removeHead();
        } else if (node == tail) {
            removeTail();
        } else {
            ListNodeWithPrev prevNode = node.prev;
            ListNodeWithPrev nextNode = node.next;
            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
            hashMap.remove(key);
        }
    }

    private void addToTail(int key, int value) {
        ListNodeWithPrev newNode = new ListNodeWithPrev(key, value);
        if (tail != null) {
            tail.prev = newNode;
            newNode.next = tail;
        } else {
            head = newNode;
        }
        tail = newNode;
        hashMap.put(key, newNode);
    }

    /** 测试用方法 **/
    public static void performTest() {
        BM100 solution = new BM100(3);
        solution.set(1, 1);
        solution.set(2, 2);
        solution.set(3, 3);
        System.out.println(solution.get(2));
        solution.set(4, 4);
        solution.set(5, 5);
        System.out.println(solution.get(2));
    }
}
