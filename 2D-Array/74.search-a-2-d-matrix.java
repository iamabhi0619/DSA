/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        while (row < matrix.length) {
            boolean ch = binarySearch(matrix[row], target);
            if (ch) {
                return true;
            }
            row++;
        }

        return false;
    }
}
// @lc code=end
