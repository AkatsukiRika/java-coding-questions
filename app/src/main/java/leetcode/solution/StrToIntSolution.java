package leetcode.solution;

import leetcode.BaseSolution;

import java.util.LinkedList;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * 难易度：Medium
 */
public class StrToIntSolution extends BaseSolution<Integer> {
    @Override
    public Integer performSingleTest() {
        return strToInt("0-1");
    }

    enum Status {
        READY,
        ZERO_BEGIN,
        SIGN,
        NUMBER,
        NUMBER_END,
        FAILURE
    }
    
    private Status status = Status.READY;
    
    public int strToInt(String str) {
        LinkedList<Character> charStack = new LinkedList<>();
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (status == Status.READY) {
                if (isSign(currentChar)) {
                    isNegative = isNegativeSign(currentChar);
                    status = Status.SIGN;
                } else if (isEmpty(currentChar)) {
                    status = Status.READY;
                } else if (isZero(currentChar)) {
                    status = Status.ZERO_BEGIN;
                } else if (isNumber(currentChar)) {
                    charStack.addFirst(currentChar);
                    status = Status.NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.SIGN) {
                if (isZero(currentChar)) {
                    status = Status.ZERO_BEGIN;
                } else if (isNumber(currentChar)) {
                    charStack.addFirst(currentChar);
                    status = Status.NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.ZERO_BEGIN) {
                if (isZero(currentChar)) {
                    status = Status.ZERO_BEGIN;
                } else if (isNumber(currentChar)) {
                    charStack.addFirst(currentChar);
                    status = Status.NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.NUMBER) {
                if (isNumber(currentChar)) {
                    charStack.addFirst(currentChar);
                    status = Status.NUMBER;
                } else {
                    status = Status.NUMBER_END;
                }
            }
        }
        if (charStack.size() > 10) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int result = 0;
        long remain;
        if (isNegative) {
            remain = Integer.MIN_VALUE * (-1L);
        } else {
            remain = Integer.MAX_VALUE;
        }
        long multiplier = 1;
        while (!charStack.isEmpty()) {
            char currentChar = charStack.pop();
            int currentInt = currentChar - '0';
            if (currentInt * multiplier >= remain) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                result += currentInt * multiplier;
                remain -= currentInt * multiplier;
                multiplier *= 10;
            }
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }
    
    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }
    
    private boolean isNegativeSign(char c) {
        return c == '-';
    }
    
    private boolean isEmpty(char c) {
        return c == ' ';
    }
    
    private boolean isZero(char c) {
        return c == '0';
    }
    
    private boolean isNumber(char c) {
        char[] numbers = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        for (char number : numbers) {
            if (c == number) {
                return true;
            }
        }
        return false;
    }
}