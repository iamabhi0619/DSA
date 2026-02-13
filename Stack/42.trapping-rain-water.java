/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2)
            return 0;
        int[] maxInLeft = new int[n];
        int[] maxInRight = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            maxInLeft[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            maxInRight[i] = max;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(maxInLeft[i], maxInRight[i]) - height[i];
        }
        return res;
    }
}
// @lc code=end
