/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double Sum = 0;
        for (int i = 0; i < k; i++) {
            Sum += nums[i];
        }
        double maxSum = Sum;
        for (int i = k; i < nums.length; i++) {
            Sum = Sum + nums[i] - nums[i - k];
            Math.max(maxSum, Sum);
        }
        return maxSum / k;
    }
}
// @lc code=end
