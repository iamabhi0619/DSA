/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {

    public int binarySearch(int[] arr, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int need, found;
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            need = target - numbers[i];
            found = binarySearch(numbers, i + 1, n - 1, need);
            if (found != -1) {
                return new int[] { i + 1, found + 1 };
            }
        }

        return new int[] { -1, -1 };
    }
}
// @lc code=end
