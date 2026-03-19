/*
 * @lc app=leetcode id=1051 lang=java
 *
 * [1051] Height Checker
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        int n = temp.length;
        for (int i = 0; i < n; i++) {
            boolean swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    int t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (temp[i] != heights[i])
                res++;
        }
        return res;
    }
}
// @lc code=end
