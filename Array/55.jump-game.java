/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == 0) {
                return false;
            }
            i += nums[i];
        }
        return true;
    }
}
// @lc code=end
