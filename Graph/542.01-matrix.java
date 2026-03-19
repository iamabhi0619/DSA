
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    class Triplets {
        int row;
        int col;
        int dist;

        Triplets(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Triplets> queue = new LinkedList<Triplets>();
        int[][] res = new int[m][n];
        int visited[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Triplets(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            Triplets temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = temp.row + delRow[i];
                int newCol = temp.col + delCol[i];
                boolean check = newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0;
                if (check) {
                    res[newRow][newCol] = temp.dist + 1;
                    visited[newRow][newCol] = 1;
                    queue.offer(new Triplets(newRow, newCol, temp.dist + 1));
                }
            }
        }
        return res;
    }
}
// @lc code=end
