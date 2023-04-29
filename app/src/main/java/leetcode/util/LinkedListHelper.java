package leetcode.util;

import leetcode.model.ListNode;
import leetcode.model.Node;

import java.util.ArrayList;

public final class LinkedListHelper {
    public static ListNode createLinkedList(int[] arr) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (int item : arr) {
            ListNode node = new ListNode(item);
            listNodes.add(node);
        }
        for (int i = 0; i < listNodes.size(); i++) {
            ListNode currentNode = listNodes.get(i);
            if (i + 1 < listNodes.size()) {
                currentNode.next = listNodes.get(i + 1);
            }
        }
        if (!listNodes.isEmpty()) {
            return listNodes.get(0);
        } else {
            return null;
        }
    }

    /**
     * @param vals 链表中每一项的val
     * @param randomIndices 链表中每一项的random指针指向链表中的第几个节点（从0开始计数，可为空）
     */
    public static Node createRandomLinkedList(int[] vals, Integer[] randomIndices) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int val : vals) {
            Node node = new Node(val);
            nodes.add(node);
        }
        for (int i = 0; i < nodes.size(); i++) {
            Node currentNode = nodes.get(i);
            if (i + 1 < nodes.size()) {
                currentNode.next = nodes.get(i + 1);
            }
            Integer randomIndex = randomIndices[i];
            if (randomIndex != null) {
                currentNode.random = nodes.get(randomIndex);
            }
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }
}