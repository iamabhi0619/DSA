/*
 * @lc app=leetcode id=390 lang=java
 *
 * [390] Elimination Game
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        if (n == 1)
            return 1;
        int remaining = n / 2;

        int smallPart = lastRemaining(remaining);

        int position = (remaining + 1) - smallPart;

        return 2 * position;
    }
}
// @lc code=end
