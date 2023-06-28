package leetcode.nowcoder;

import java.util.LinkedList;

/**
 * 牛客网BM44：有效括号序列
 */
public class BM44 {
    private final LinkedList<Character> stack = new LinkedList<>();

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Character stackTop = stack.peekFirst();
            if (stackTop != null) {
                boolean needPop = (currentChar == '}' && stackTop == '{')
                        || (currentChar == ']' && stackTop == '[')
                        || (currentChar == ')' && stackTop == '(');
                if (needPop) {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
}
