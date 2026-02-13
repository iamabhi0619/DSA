/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isFirstRowHasZero = false;
        boolean isFirstColHasZero = false;

        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowHasZero = true;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                isFirstColHasZero = true;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowHasZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isFirstColHasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
// @lc code=end
