import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
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

    public int maximalRectangle(char[][] charMatrix) {
        int n = charMatrix.length;
        int m = charMatrix[0].length;
        int res = 0;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int) charMatrix[i][j] - '0';
            }
        }
        int[] histogram = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    histogram[j] = 0;
                else {
                    histogram[j] += matrix[i][j];
                }
            }
            for (int h : histogram) {
                System.out.print(h + " ");
            }
            System.out.println();
            int currArea = largestRectangleArea(histogram);
            res = Math.max(res, currArea);
        }
        return res;
    }
}


// @lc code=end
