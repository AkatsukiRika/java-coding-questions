package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.ListNode;
import leetcode.util.LinkedListHelper;

import java.util.ArrayList;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 难易度：Easy
 */
public class MergeTwoListsSolution extends BaseSolution<ListNode> {
    @Override
    public ListNode performSingleTest() {
        return mergeTwoLists(
                LinkedListHelper.createLinkedList(new int[]{1}),
                LinkedListHelper.createLinkedList(new int[]{1})
        );
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        
        while (ptr1 != null && ptr2 != null) {
            if (ptr2.val <= ptr1.val) {
                listNodes.add(ptr2);
                ptr2 = ptr2.next;
            } else {
                listNodes.add(ptr1);
                ptr1 = ptr1.next;
            }
        }
        while (ptr1 != null) {
            listNodes.add(ptr1);
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            listNodes.add(ptr2);
            ptr2 = ptr2.next;
        }
        
        for (int i = 0; i < listNodes.size(); i++) {
            ListNode currentNode = listNodes.get(i);
            if (i + 1 < listNodes.size()) {
                currentNode.next = listNodes.get(i + 1);
            }
        }
        
        return listNodes.isEmpty() ? null : listNodes.get(0);
    }
}