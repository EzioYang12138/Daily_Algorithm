
//Definition for a binary tree node.

//https://leetcode-cn.com/problems/path-sum/submissions/

public class _7_07 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            return true;
        } else {
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }
}
