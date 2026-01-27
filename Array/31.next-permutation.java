
import java.util.Collections;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int p = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        if (p == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                break;
            }
        }
        reverse(nums, p + 1, n - 1);
    }
}
// @lc code=end
