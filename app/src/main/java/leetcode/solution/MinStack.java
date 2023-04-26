package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 难易度：Easy
 */
public class MinStack extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        int tmp;
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        tmp = minStack.min();
        System.out.println(tmp);
        
        minStack.pop();
        
        tmp = minStack.top();
        System.out.println(tmp);
        
        tmp = minStack.min();
        System.out.println(tmp);
        
        return 0;
    }
    
    private static class MinStackNode {
        int val;
        MinStackNode prev = null;
        MinStackNode next = null;
        int min = Integer.MAX_VALUE;
        
        MinStackNode(int val) {
            this.val = val;
        }
    }
    
    private MinStackNode head;

    public MinStack() {
    }
    
    public void push(int x) {
        if (head == null) {
            head = new MinStackNode(x);
            head.min = x;
        } else {
            MinStackNode newNode = new MinStackNode(x);
            newNode.min = Math.min(x, head.min);
            newNode.prev = head;
            head.next = newNode;
            head = head.next;
        }
    }
    
    public void pop() {
        head = head.prev;
        if (head != null) {
            head.next = null;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int min() {
        return head.min;
    }
}