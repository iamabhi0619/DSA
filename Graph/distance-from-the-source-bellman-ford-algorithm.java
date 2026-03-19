
import java.util.*;

// User function Template for Java

class Pair {
    int node;
    int dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

}

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int[] res = new int[V];
        for (int i = 0; i < V; i++) {
            res[i] = (int) 1e8;
        }

        


        return res;

    }
}
