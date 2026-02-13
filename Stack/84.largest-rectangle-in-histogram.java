
import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Pair> stack = new Stack<>();
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().first >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = i + 1;
            } else {
                nsl[i] = i - stack.peek().second;
            }
            stack.push(new Pair(heights[i], i));
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().first >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = n - i;
            } else {
                nsr[i] = stack.peek().second - i;
            }
            stack.push(new Pair(heights[i], i));
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int width = nsl[i] + nsr[i] - 1;
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }
}
// @lc code=end
