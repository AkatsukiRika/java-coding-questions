package leetcode.solution;

/**
 * 剑指 Offer 05. 替换空格
 * 难易度：Easy
 */
public class ReplaceSpaceSolution {
    public String replaceSpace(String s) {
        if (s.isEmpty()) {
            return "";
        }
        return s.replace(" ", "%20");
    }
}