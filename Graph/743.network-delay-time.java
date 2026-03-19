
import java.util.*;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start

class Pair {
    int node;
    int time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Pair(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();

            if (temp.time > dist[temp.node])
                continue;

            for (Pair na : adj.get(temp.node)) {
                if (temp.time + na.time < dist[na.node]) {
                    dist[na.node] = temp.time + na.time;
                    pq.offer(new Pair(na.node, dist[na.node]));
                }
            }
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }
}
// @lc code=end
