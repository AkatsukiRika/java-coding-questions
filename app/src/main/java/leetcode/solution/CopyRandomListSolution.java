package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.Node;
import leetcode.util.LinkedListHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 难易度：Medium
 */
public class CopyRandomListSolution extends BaseSolution<Node> {
    @Override
    public Node performSingleTest() {
        Node originNode = LinkedListHelper.createRandomLinkedList(
                new int[]{},
                new Integer[]{}
        );
        Node copiedNode = copyRandomList(originNode);
        return copiedNode;
    }
    
    public Node copyRandomList(Node head) {
        ArrayList<Node> originNodes = new ArrayList<>();
        ArrayList<Node> copiedNodes = new ArrayList<>();
        Node ptr = head;
        Node ptr2 = head;
        while (ptr != null) {
            originNodes.add(ptr);
            copiedNodes.add(new Node(ptr.val));
            ptr = ptr.next;
        }
        int count = 0;
        LinkedHashMap<Node, Integer> randomIndices = new LinkedHashMap<>();
        while (ptr2 != null) {
            Node originNode = originNodes.get(count);
            if (originNode.random != null) {
                int randomIndex = originNodes.indexOf(originNode.random);
                randomIndices.put(originNode, randomIndex);
            } else {
                randomIndices.put(originNode, null);
            }
            count++;
            ptr2 = ptr2.next;
        }
        for (int i = 0; i < copiedNodes.size(); i++) {
            Node copiedNode = copiedNodes.get(i);
            Node originNode = originNodes.get(i);
            Integer randomIndex = randomIndices.get(originNode);
            copiedNode.random = randomIndex != null ? copiedNodes.get(randomIndex) : null;
            copiedNode.next = i + 1 < copiedNodes.size() ? copiedNodes.get(i + 1) : null;
        }
        return copiedNodes.isEmpty() ? null : copiedNodes.get(0);
    }
}