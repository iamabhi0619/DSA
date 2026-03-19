
import java.util.*;

class Pair {
    int node;
    int dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.dist - b.dist);
        int[] res = new int[V];
        for (int i = 0; i < V; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        pq.offer(new Pair(src, 0));
        res[src] = 0;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            if (temp.dist > res[temp.node])
                continue;
            for (Pair na : adj.get(temp.node)) {
                if (na.dist + temp.dist < res[na.node]) {
                    res[na.node] = na.dist + temp.dist;
                    pq.offer(new Pair(na.node, res[na.node]));
                }
            }
        }

        return res;
    }
}