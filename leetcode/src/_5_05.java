import java.util.ArrayList;

//https://leetcode-cn.com/problems/validate-binary-search-tree/

public class _5_05 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }

        return true;

    }

    public void helper(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    double last = -Double.MAX_VALUE;
    public boolean isValidBST2(TreeNode root) {

        if(root == null) return true;
        if(isValidBST2(root.left)) {
            if(last < root.val) {
                last = root.val;
                return isValidBST2(root.right);
            }
        }

        return false;

    }

}
