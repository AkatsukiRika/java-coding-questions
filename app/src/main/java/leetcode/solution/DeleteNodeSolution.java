package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.ListNode;
import leetcode.util.LinkedListHelper;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 难易度：Easy
 */
public class DeleteNodeSolution extends BaseSolution<ListNode> {
    @Override
    public ListNode performSingleTest() {
        ListNode head = LinkedListHelper.createLinkedList(
                new int[]{-3, 5, -99}
        );
        return deleteNode(head, -99);
    }
    
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return val == head.val ? null : head;
        }
        if (head.val == val) {
            return head.next;
        }
        
        ListNode oldPtr = head;
        ListNode newPtr = head.next;
        boolean found = false;
        while (oldPtr != null && newPtr != null) {
            if (found) {
                oldPtr.next = newPtr;
                found = false;
                break;
            }
            if (newPtr.val == val) {
                found = true;
                newPtr = newPtr.next;
            } else {
                oldPtr = oldPtr.next;
                newPtr = newPtr.next;
            }
        }
        if (found) {
            oldPtr.next = null;
        }
        return head;
    }
}