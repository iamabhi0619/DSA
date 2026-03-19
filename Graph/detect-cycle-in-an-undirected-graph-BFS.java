import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        int[] parents = new int[V];
        Arrays.fill(parents, -1);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean res = bfs(graph, i, parents, visited);
                if (res)
                    return true;
            }
        }
        return false;
    }

    public boolean bfs(List<List<Integer>> graph, int parent, int[] parents, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(parent);
        visited[parent] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int adjNode : graph.get(curr)) {
                if (adjNode != parents[curr] && visited[adjNode])
                    return true;
                else {
                    if (!visited[adjNode]) {
                        parents[adjNode] = curr;
                        visited[adjNode] = true;
                        q.offer(adjNode);
                    }
                }
            }
        }
        return false;
    }
}