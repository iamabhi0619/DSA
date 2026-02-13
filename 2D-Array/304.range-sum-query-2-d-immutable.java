/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    int[][] mat;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.mat = matrix;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i + 1][j + 1] = mat[i + 1][j] + mat[i][j + 1] - mat[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mat[row2 + 1][col2 + 1] - mat[row2 + 1][col1] - mat[row1][col2 + 1] + mat[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
