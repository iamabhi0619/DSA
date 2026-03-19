import java.util.*;

class Solution {
    public ArrayList<Integer> topView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        ArrayList<Integer> res = new ArrayList<>();
        for (TreeMap<Integer, Integer> rows : map.values()) {
            res.add(rows.firstEntry().getValue());
        }
        return res;
    }

    public void helper(TreeNode root, int row, int col,
            TreeMap<Integer, TreeMap<Integer, Integer>> map) {
        if (root == null)
            return;
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, root.val);

        helper(root.left, row + 1, col - 1, map);
        helper(root.right, row + 1, col + 1, map);
    }
}