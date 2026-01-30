/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    result.append(word.reverse());
                    result.append(' ');
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            result.append(word.reverse());
        }
        return result.toString();
    }
}
// @lc code=end
