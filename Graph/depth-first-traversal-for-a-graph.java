import java.util.*;

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        // dfs(adj, 0, res, visited);

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(adj, i, res, visited);
            }
        }
        return res;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int source, ArrayList<Integer> res, boolean[] visited) {
        res.add(source);
        visited[source] = true;
        for (int next : adj.get(source)) {
            if (!visited[next]) {
                dfs(adj, next, res, visited);
            }
        }
    }
}