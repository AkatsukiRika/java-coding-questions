package leetcode.solution;

import leetcode.BaseSolution;

import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 难易度：Easy
 */
public class CQueue extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        CQueue queue = new CQueue();
        System.out.println("null");
        
        int head = queue.deleteHead();
        System.out.println(head);
        
        queue.appendTail(5);
        System.out.println("null");
        
        queue.appendTail(2);
        System.out.println("null");
        
        head = queue.deleteHead();
        System.out.println(head);
        
        head = queue.deleteHead();
        System.out.println(head);
        
        return 0;
    }

    private final LinkedList<Integer> mainStack;
    
    private final LinkedList<Integer> subStack;
    
    public CQueue() {
        mainStack = new LinkedList<>();
        subStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        mainStack.addFirst(value);
    }

    public int deleteHead() {
        if (mainStack.isEmpty()) {
            return -1;
        }

        while (mainStack.size() > 1) {
            int val = mainStack.pop();
            subStack.addFirst(val);
        }
        int result = mainStack.pop();
        while (!subStack.isEmpty()) {
            int val = subStack.pop();
            mainStack.addFirst(val);
        }
        return result;
    }
}