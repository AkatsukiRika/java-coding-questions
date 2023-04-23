package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.ListNode;
import leetcode.util.LinkedListHelper;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReversePrintSolution extends BaseSolution<int[]> {
    @Override
    public int[] performSingleTest() {
        ArrayList<int[]> testCases = new ArrayList<>();
        testCases.add(new int[]{});
        testCases.add(new int[]{1});
        testCases.add(new int[]{1, 3, 2});
        testCases.add(new int[]{0, 1, 8, 4, 1, 5, 4, 1, 1});
        
        ListNode head = LinkedListHelper.createLinkedList(
                testCases.get(3)
        );
        return reversePrint(head);
    }
    
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addFirst(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int ptr = 0;
        while (!stack.isEmpty()) {
            result[ptr++] = stack.pop();
        }
        return result;
    }
}