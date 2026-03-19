
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        TreeNode temp = root;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || temp != null) {
            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            res.add(temp.val);
            temp = temp.right;
        }

        return res;
    }
}
// @lc code=end
