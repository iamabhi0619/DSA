/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        // Miss the blank space
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Sign Check
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < n && (Character.isDigit(s.charAt(i)))) {
            int digit = s.charAt(i) - '0';
            if (res > max / 10 || res == max / 10 && digit > 7) {
                return sign == 1 ? max : min;
            }
            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }
}
// @lc code=end
