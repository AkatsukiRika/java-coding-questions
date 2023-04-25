package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.ListNode;
import leetcode.util.LinkedListHelper;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 难易度：Easy
 */
public class GetKthFromEndSolution extends BaseSolution<ListNode> {
    @Override
    public ListNode performSingleTest() {
        return getKthFromEnd(
                LinkedListHelper.createLinkedList(new int[]{}),
                1
        );
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode oldPtr = head;
        ListNode newPtr = head;
        int size = 0;
        while (newPtr != null) {
            size++;
            newPtr = newPtr.next;
        }
        for (int i = 0; i < size - k; i++) {
            if (oldPtr != null) {
                oldPtr = oldPtr.next;
            }
        }
        return oldPtr;
    }
}