package leetcode.solution;

import leetcode.BaseSolution;

import java.util.ArrayList;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 难易度：Easy
 */
public class ReverseLeftWordsSolution extends BaseSolution<String> {
    @Override
    public String performSingleTest() {
        return null;
    }

    public String reverseLeftWords(String s, int n) {
        if (s.isEmpty()) {
            return "";
        }
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            Character removed = charList.remove(0);
            charList.add(removed);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : charList) {
            sb.append(c);
        }
        return sb.toString();
    }
}