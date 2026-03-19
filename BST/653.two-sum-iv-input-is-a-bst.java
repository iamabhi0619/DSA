
import java.util.*;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inOrder(arr, root);
        int start = 0;
        int end = arr.size() - 1;
        while (start < end) {
            int sum = arr.get(start) + arr.get(end);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public void inOrder(List<Integer> arr, TreeNode root) {
        if (root == null)
            return;
        inOrder(arr, root.left);
        arr.add(root.val);
        inOrder(arr, root.right);
    }
}
// @lc code=end
