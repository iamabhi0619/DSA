
import java.util.*;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                if (!leftToRight) {
                    Collections.reverse(tempList);
                }
                res.add(new ArrayList<>(tempList));
                tempList.clear();
                leftToRight = !leftToRight;
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                tempList.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }

        }
        return res;
    }
}
// @lc code=end
