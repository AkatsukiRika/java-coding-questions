package leetcode.util;

import leetcode.model.ListNode;

public final class Printer {
    public static <T> void printArray(T[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }
}