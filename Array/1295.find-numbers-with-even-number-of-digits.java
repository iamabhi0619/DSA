/*
 * @lc app=leetcode id=1295 lang=java
 *
 * [1295] Find Numbers with Even Number of Digits
 */

// @lc code=start
class Solution {

    public int numberOfDigits(int nums) {
        int count = 0;
        while (nums > 0) {
            count++;
            nums = nums / 10;
        }
        return count;
    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numberOfDigits(nums[i]) % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
