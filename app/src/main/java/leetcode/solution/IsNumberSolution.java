package leetcode.solution;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 难易度：Medium
 */
public class IsNumberSolution {
    enum Status {
        BEGIN,
        READY,
        NUMBER,
        FLOAT_BEGIN,    // 小数点前没有数字
        FLOAT_NUMBER,   // 小数点后的数字
        SCIENTIFIC_BEGIN,
        SCIENTIFIC_READY,
        SCIENTIFIC_NUMBER,
        FAILURE
    }

    private Status status = Status.BEGIN;

    public boolean isNumber(String s) {
        String inputStr = s.trim();
        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);
            System.out.println("isNumber, currentChar=" + currentChar + ", status from=" + status);

            if (status == Status.BEGIN) {
                if (isBeginSign(currentChar)) {
                    status = Status.READY;
                } else if (isPoint(currentChar)) {
                    status = Status.FLOAT_BEGIN;
                } else if (isNumber(currentChar)) {
                    status = Status.NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.READY) {
                if (isPoint(currentChar)) {
                    status = Status.FLOAT_BEGIN;
                } else if (isNumber(currentChar)) {
                    status = Status.NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.FLOAT_BEGIN) {
                if (isNumber(currentChar)) {
                    status = Status.FLOAT_NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.FLOAT_NUMBER) {
                if (isNumber(currentChar)) {
                    status = Status.FLOAT_NUMBER;
                } else if (isScientific(currentChar)) {
                    status = Status.SCIENTIFIC_BEGIN;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.NUMBER) {
                if (isNumber(currentChar)) {
                    status = Status.NUMBER;
                } else if (isPoint(currentChar)) {
                    status = Status.FLOAT_NUMBER;
                } else if (isScientific(currentChar)) {
                    status = Status.SCIENTIFIC_BEGIN;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.SCIENTIFIC_BEGIN) {
                if (isBeginSign(currentChar)) {
                    status = Status.SCIENTIFIC_READY;
                } else if (isNumber(currentChar)) {
                    status = Status.SCIENTIFIC_NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            } else if (status == Status.SCIENTIFIC_READY || status == Status.SCIENTIFIC_NUMBER) {
                if (isNumber(currentChar)) {
                    status = Status.SCIENTIFIC_NUMBER;
                } else {
                    status = Status.FAILURE;
                    break;
                }
            }
            System.out.println("status end=" + status);
        }
        return status != Status.FAILURE
               && status != Status.FLOAT_BEGIN
               && status != Status.BEGIN
               && status != Status.SCIENTIFIC_BEGIN
               && status != Status.SCIENTIFIC_READY
               && status != Status.READY;
    }

    private boolean isBeginSign(char c) {
        return c == '+' || c == '-';
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

    private boolean isPoint(char c) {
        return c == '.';
    }
    
    private boolean isScientific(char c) {
        return c == 'e' || c == 'E';
    }
}