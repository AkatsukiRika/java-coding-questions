package leetcode.util;

import leetcode.model.ListNode;

import java.util.List;

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

    public static <T> void printList(List<T> list) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toString());
            if (i != list.size() - 1) {
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