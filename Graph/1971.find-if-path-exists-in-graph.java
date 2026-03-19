
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1971 lang=java
 *
 * [1971] Find if Path Exists in Graph
 */

// @lc code=start
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] temp : edges) {
            int nodeFrom = temp[0];
            int nodeTo = temp[1];
            graph.get(nodeFrom).add(nodeTo);
            graph.get(nodeTo).add(nodeFrom);
        }
        Queue<Integer> queue = new LinkedList<>();

        int visited[] = new int[n];

        queue.offer(source);
        visited[source] = 1;
        while (!queue.isEmpty()) {
            int current = queue.remove();
            ArrayList<Integer> temp = graph.get(current);
            for (int i : temp) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    if (i == destination)
                        return true;
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}
// @lc code=end
