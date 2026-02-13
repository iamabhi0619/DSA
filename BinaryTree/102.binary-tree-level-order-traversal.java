
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                res.add(new ArrayList<>(tempList));
                tempList.clear();
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
