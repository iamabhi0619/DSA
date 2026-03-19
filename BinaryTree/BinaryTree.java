
public class BinaryTree {
    void printTree(TreeNode root) {
        printCompactHelper(root, "", "", "");
    }

    private void printCompactHelper(TreeNode node, String prefix, String childPrefix, String label) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + label + node.val);

        if (node.left != null && node.right != null) {
            printCompactHelper(node.left, childPrefix + "├── ", childPrefix + "│   ", "");
            printCompactHelper(node.right, childPrefix + "└── ", childPrefix + "    ", "");
        } else if (node.left != null) {
            printCompactHelper(node.left, childPrefix + "└── ", childPrefix + "    ", "");
        } else if (node.right != null) {
            printCompactHelper(node.right, childPrefix + "└── ", childPrefix + "    ", "");
        }
    }

}
