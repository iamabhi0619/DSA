
import java.util.*;

/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start

class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = edges.length;
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int j : edges[i]) {
                graph.get(i).add(j);
            }
        }

        int[] state = new int[V]; // 0=unvisited, 1=visiting, 2=safe
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (dfs(i, graph, state)) {
                res.add(i);
            }
        }

        return res;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }
        state[node] = 1;

        for (int adj : graph.get(node)) {
            if (state[adj] == 1 || !dfs(adj, graph, state)) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}
// @lc code=end
