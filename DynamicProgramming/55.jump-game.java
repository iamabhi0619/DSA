/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return helper(0, nums, memo);
    }

    private boolean helper(int index, int[] nums, Boolean[] memo) {
        if (index >= nums.length - 1) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int maxJump = nums[index];

        for (int step = 1; step <= maxJump; step++) {
            if (helper(index + step, nums, memo)) {
                return memo[index] = true;
            }
        }

        return memo[index] = false;
    }
}

// @lc code=end
