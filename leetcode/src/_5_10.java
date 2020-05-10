public class _5_10 {

//    https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        if (p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
            // 这里必须用 else if 不能用else  不然下边的return null 将不能执行
        } else if (right != null) {
            return right;
        }

        return null;

    }
}
