import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int n : adj.get(curr)) {
                if (!visited[n]) {
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }

        return res;
    }
}