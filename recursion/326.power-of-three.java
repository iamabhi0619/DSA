/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }
}
// @lc code=end
