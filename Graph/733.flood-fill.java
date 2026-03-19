/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] visited = new int[m][n];
        dfs(sr, sc, image, color, image[sr][sc], visited, n, m);
        return image;
    }

    public void dfs(int row, int col, int[][] image, int color, int currentColor, int[][] visited, int n, int m) {
        visited[row][col] = 1;
        image[row][col] = color;
        int[] delRow = { 0, 0, -1, 1 };
        int[] delCol = { -1, 1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            boolean check = newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && image[newRow][newCol] == currentColor && visited[newRow][newCol] == 0;

            if (check) {
                dfs(newRow, newCol, image, color, currentColor, visited, n, m);
            }
        }
    }
}
// @lc code=end
