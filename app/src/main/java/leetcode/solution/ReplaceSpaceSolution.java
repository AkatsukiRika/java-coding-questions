package leetcode.solution;

import leetcode.BaseSolution;

/**
 * 剑指 Offer 05. 替换空格
 * 难易度：Easy
 */
public class ReplaceSpaceSolution extends BaseSolution<String> {
    @Override
    public String performSingleTest() {
        return replaceSpace("We are happy.");
    }

    public String replaceSpace(String s) {
        if (s.isEmpty()) {
            return "";
        }
        return s.replace(" ", "%20");
    }
}