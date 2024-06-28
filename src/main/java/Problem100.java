public class Problem100 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), null);
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(same(treeNode1,treeNode2));
    }

    static boolean same(TreeNode p, TreeNode q) {
        try {
            if (p.val != q.val) {
                return false;
            }
            return same(p.right, q.right) && same(p.left,q.left);
        } catch (NullPointerException e) {
            if (p == null && q == null) return true;
            return false;
        }
    }
}
