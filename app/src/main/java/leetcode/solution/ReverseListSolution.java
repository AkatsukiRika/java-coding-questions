package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.ListNode;
import leetcode.util.LinkedListHelper;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指 Offer 24. 反转链表
 * 难易度：Easy
 */
public class ReverseListSolution extends BaseSolution<ListNode> {
    @Override
    public ListNode performSingleTest() {
        ArrayList<int[]> testCases = new ArrayList<>();
        testCases.add(new int[]{});
        testCases.add(new int[]{1});
        testCases.add(new int[]{1, 2, 3, 4, 5});
        testCases.add(new int[]{1, 1, 4, 5, 1, 4, 1, 9, 1, 9, 8, 1, 0});
        
        ListNode head = LinkedListHelper.createLinkedList(
                testCases.get(3)
        );
        return reverseList(head);
    }
    
    public ListNode reverseList(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.addFirst(head);
            head = head.next;
        }
        ListNode resultHead = null;
        while (!stack.isEmpty()) {
            ListNode currentNode = stack.pop();
            currentNode.next = stack.peekFirst();
            if (resultHead == null) {
                resultHead = currentNode;
            }
        }
        return resultHead;
    }
}