/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : connections) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[0]).add(-path[1]);
            graph.get(path[1]).add(-path[0]);
        }
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            List<Integer> currNode = graph.get(q.poll());
            for (int node : currNode) {
                if (node > 0) {
                    if (!visited[node]) {
                        res++;
                        visited[node] = true;
                        q.offer(node);
                    }
                } else {
                    if (!visited[-node]) {
                        visited[-node] = true;
                        q.offer(-node);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
