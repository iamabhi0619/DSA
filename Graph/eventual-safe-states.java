
import java.util.*;

class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] state = new int[V]; // 0=unvisited, 1=visiting, 2=safe
        ArrayList<Integer> res = new ArrayList<>();

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