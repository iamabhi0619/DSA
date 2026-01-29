/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int n = 0;
        int leftSum;
        int rightSum = 0;
        if (n == 1)
            return 0;
        for (int num : nums) {
            rightSum += num;
        }
        leftSum = nums[0];
        rightSum -= nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return -1;
    }
}
// @lc code=end
