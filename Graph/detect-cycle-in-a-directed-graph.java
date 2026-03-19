
import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] isInPath = new boolean[V];
        for (int i = 0; i < V; i++) {
            boolean res = dfs(graph, i, visited, isInPath);
            if (res)
                return true;
        }
        return false;
    }

    public boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] isInPath) {
        visited[node] = true;
        isInPath[node] = true;
        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(graph, adjNode, visited, isInPath))
                    return true;
            } else if (isInPath[adjNode])
                return true;
        }
        isInPath[node] = false;
        return false;
    }
}