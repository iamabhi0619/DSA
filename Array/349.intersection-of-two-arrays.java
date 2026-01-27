/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] visited = new boolean[1001];
        int curr = 0;
        for (int num : nums1) {
            visited[num] = true;
        }
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        for (int num : nums2) {
            if (visited[num]) {
                visited[num] = false;
                temp[curr++] = num;
            }
        }
        int[] res = new int[curr];
        for (int i = 0; i < curr; i++) {
            res[i] = temp[i];
        }
        return res;
    }
}
// @lc code=end
