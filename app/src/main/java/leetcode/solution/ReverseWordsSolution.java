package leetcode.solution;

import leetcode.BaseSolution;

import java.util.LinkedList;

public class ReverseWordsSolution extends BaseSolution<String> {
    @Override
    public String performSingleTest() {
        return reverseWords("1 ");
    }
    
    enum Status {
        IDLE, SPACE, LETTER
    }
    
    private Status status = Status.IDLE;
    
    public String reverseWords(String s) {
        LinkedList<String> wordsList = new LinkedList<>();
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (status == Status.IDLE) {
                if (isSpace(currentChar)) {
                    status = Status.IDLE;
                } else {
                    wordBuilder.append(currentChar);
                    status = Status.LETTER;
                }
            } else if (status == Status.SPACE) {
                if (wordBuilder.length() > 0) {
                    wordsList.addFirst(wordBuilder.toString());
                    wordBuilder = new StringBuilder();   
                }
                if (isSpace(currentChar)) {
                    status = Status.SPACE;
                } else {
                    wordBuilder.append(currentChar);
                    status = Status.LETTER;
                }
            } else {
                if (isSpace(currentChar)) {
                    status = Status.SPACE;
                } else {
                    wordBuilder.append(currentChar);
                    status = Status.LETTER;
                }
            }
        }
        if (status == Status.IDLE) {
            return "";
        } else if (wordBuilder.length() > 0) {
            wordsList.addFirst(wordBuilder.toString());
        }
        wordBuilder = new StringBuilder();
        while (!wordsList.isEmpty()) {
            wordBuilder.append(wordsList.pop());
            wordBuilder.append(" ");
        }
        return wordBuilder.toString().trim();
    }
    
    private boolean isSpace(char c) {
        return c == ' ';
    }
}