/*
 * @lc app=leetcode id=3304 lang=java
 *
 * [3304] Find the K-th Character in String Game I
 */

// @lc code=start
class Solution {
    StringBuilder str = new StringBuilder("a");

    public char kthCharacter(int k) {
        if (str.length() >= k) {
            return str.charAt(k - 1);
        }

        StringBuilder temp = new StringBuilder(str);
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            char next = (char) ((c - 'a' + 1) % 26 + 'a');
            temp.setCharAt(i, next);
        }
        str.append(temp);
        return kthCharacter(k);
    }
}
// @lc code=end
