/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = 0;
        int right = 0;
        if (root.left != null)
            left = countNodes(root.left);
        if (root.right != null)
            right = countNodes(root.right);
        return 1 + left + right;
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        int right = 0;
        if (root.left != null)
            left = height(root.left);
        if (root.right != null)
            right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
// @lc code=end
