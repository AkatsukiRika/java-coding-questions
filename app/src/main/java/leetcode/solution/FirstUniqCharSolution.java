package leetcode.solution;

import leetcode.BaseSolution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 难易度：Easy
 */
public class FirstUniqCharSolution extends BaseSolution<Character> {
    @Override
    public Character performSingleTest() {
        return firstUniqChar("abaccdeff");
    }
    
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            map.merge(now, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}