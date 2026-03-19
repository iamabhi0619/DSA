
import java.util.*;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER m
     * 3. 2D_INTEGER_ARRAY edges
     * 4. INTEGER s
     */

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.dist = dist;
            this.node = node;
        }

    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0) - 1).add(edge.get(1) - 1);
            adj.get(edge.get(1) - 1).add(edge.get(0) - 1);
        }

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(new Pair(s - 1, 0));
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = -1;
        }

        visited[s - 1] = true;

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            for (int na : adj.get(temp.node)) {
                if (!visited[na]) {
                    queue.offer(new Pair(na, temp.dist + 6));
                    distance[na] = temp.dist + 6;
                    visited[na] = true;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != s - 1) {
                res.add(distance[i]);
            }
        }

        return res;

    }

}