package easy;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4),new TreeNode(5)),new TreeNode(3, new TreeNode(6), new TreeNode(7)));
//        fillTree(root);
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> strings = new ArrayList<>();
        search(root, "", strings);
        return strings;
    }

    private static void search(TreeNode root, String path, ArrayList<String> strings) {
        if (root.left == null && root.right == null) strings.add(path + root.val);
        if (root.left != null) search(root.left, path + root.val + "->", strings);
        if (root.right != null) search(root.right, path + root.val + "->", strings);
    }

    private static int counter = 2;

    private static void fillTree(TreeNode node) {
        if (node == null || counter > 5) return;

        if (node.left == null && counter <= 5) {
            node.left = new TreeNode(counter++);
        }
        if (node.right == null && counter <= 5) {
            node.right = new TreeNode(counter++);
        }

        fillTree(node.left);
        fillTree(node.right);
    }
}
