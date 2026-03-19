import java.util.*;
/*
 * @lc app=leetcode id=1976 lang=java
 *
 * [1976] Number of Ways to Arrive at Destination
 */

// @lc code=start
class Solution {
    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = (int) 1e9 + 7;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            long d = cur.dist;
            int node = cur.node;

            if (d > dist[node])
                continue;

            for (Pair next : adj.get(node)) {
                long newDist = d + next.dist;

                if (newDist < dist[next.node]) {
                    dist[next.node] = newDist;
                    ways[next.node] = ways[node];
                    pq.offer(new Pair(next.node, newDist));
                } else if (newDist == dist[next.node]) {
                    ways[next.node] = (ways[next.node] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
// @lc code=end
