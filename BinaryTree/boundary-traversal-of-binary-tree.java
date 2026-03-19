import java.util.*;

class Solution {
    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> leaf = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        if (root == null)
            return new ArrayList<>();

        if (root.left == null && root.right == null) {
            List<Integer> res = new ArrayList<>();
            res.add(root.val);
            return new ArrayList<>(res);
        }

        left.add(root.val);

        leftSide(root.left, left);
        leafSide(root, leaf);
        rightSide(root.right, right);
        
        Collections.reverse(right);
        left.addAll(leaf);
        left.addAll(right);
        return new ArrayList<>(left);
    }

    void leftSide(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left != null || root.right != null)
            list.add(root.val);
        if (root.left != null)
            leftSide(root.left, list);
        else
            leftSide(root.right, list);
    }

    void leafSide(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            list.add(root.val);
        leafSide(root.left, list);
        leafSide(root.right, list);
    }

    void rightSide(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.right != null || root.left != null)
            list.add(root.val);
        if (root.right != null)
            rightSide(root.right, list);
        else
            rightSide(root.left, list);
    }
}