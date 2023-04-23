package leetcode.util;

import leetcode.model.ListNode;

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
}