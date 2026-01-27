/*
 * @lc app=leetcode id=1929 lang=java
 *
 * [1929] Concatenation of Array
 */

// @lc code=start
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                res[i] = nums[i];
            } else {
                res[i] = nums[n - i];
            }
        }

        return res;
    }
}
// @lc code=end
