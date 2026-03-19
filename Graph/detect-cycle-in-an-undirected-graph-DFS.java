import java.util.*;

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

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
        Stack<Pair> s = new Stack<>();
        for (int i = 0; i < V; i++) {
            s.clear();
            if (!visited[i]) {
                s.push(new Pair(i, -1));
                visited[i] = true;
                while (!s.isEmpty()) {
                    Pair current = s.pop();
                    for (int adjNode : graph.get(current.node)) {
                        if (adjNode != current.parent && visited[adjNode])
                            return true;
                        if (!visited[adjNode]) {
                            visited[adjNode] = true;
                            s.push(new Pair(adjNode, current.node));
                        }
                    }
                }
            }
        }
        return false;
    }
}