/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length-1);
    }

    public TreeNode createTree(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int mid = (high + low) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = createTree(nums, low, mid - 1);
        temp.right = createTree(nums, mid + 1, high);
        return temp;
    }
}
// @lc code=end
