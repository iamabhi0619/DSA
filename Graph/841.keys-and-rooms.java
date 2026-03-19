
import java.util.*;

/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = 1;
        while (!q.isEmpty()) {
            for (int key : rooms.get(q.poll())) {
                if (visited[key] == 0) {
                    visited[key] = 1;
                    q.offer(key);
                }
            }
        }
        for (int v : visited) {
            if (v == 0)
                return false;
        }
        return true;
    }
}
// @lc code=end
