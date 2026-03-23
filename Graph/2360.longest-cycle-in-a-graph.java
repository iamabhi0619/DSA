
import java.util.*;

/*
 * @lc app=leetcode id=2360 lang=java
 *
 * [2360] Longest Cycle in a Graph
 */

// @lc code=start
class Solution {
    private int res = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        boolean[] inPath = new boolean[n];
        int[] pathLength = new int[n];
        Arrays.fill(pathLength, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, edges, visited, inPath, pathLength, 0);
            }
        }

        return res;
    }

    public void dfs(int node, int[] edges, boolean[] visited, boolean[] inPath, int[] pathLength,
            int currPathLength) {
        visited[node] = true;
        inPath[node] = true;
        pathLength[node] = currPathLength;

        int next = edges[node];

        if (next != -1) {
            if (!visited[next]) {
                dfs(next, edges, visited, inPath, pathLength, currPathLength + 1);
            } else if (inPath[next]) {
                int cycleLength = currPathLength - pathLength[next] + 1;
                res = Math.max(res, cycleLength);
            }
        }
        inPath[node] = false;
    }
}
// @lc code=end
