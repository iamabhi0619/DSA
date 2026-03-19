/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start

import java.util.*;

class Pair {
    int i;
    int j;
    int distance;

    public Pair(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        int[] pi = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] pj = { -1, 0, 1, -1, 1, -1, 0, 1 };
        boolean[][] visited = new boolean[n][n];

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            if (current.i == n - 1 && current.j == n - 1)
                return current.distance + 1;
            for (int i = 0; i < 8; i++) {
                int tempi = pi[i] + current.i;
                int tempj = pj[i] + current.j;
                if (tempi >= 0 && tempi < n && tempj >= 0 && tempj < n) {
                    if (!visited[tempi][tempj] && grid[tempi][tempj] != 1) {
                        visited[tempi][tempj] = true;
                        q.offer(new Pair(tempi, tempj, current.distance + 1));
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end
