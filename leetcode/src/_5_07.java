public class _5_07 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

//    https://leetcode-cn.com/problems/subtree-of-another-tree/submissions/

//    public boolean isSubtree(TreeNode s, TreeNode t){
//        if(s == null && t == null) return true;
//        if(s == null || t == null) return false;
////        这样写是不对的，因为s.val == t.val 不代表这两棵树就是相同的，也许只是s根节点跟叶子节点相同
//        if(s.val == t.val) {
//            return isSubtree(s.left , t.left) && isSubtree(s.right , t.right);
//        }else {
//            return isSubtree(s.left , t) || isSubtree(s.right , t);
//        }
//    }

//    正确写法

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return isSameTree(s , t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isSameTree(s.left , t.left) && isSameTree(s.right , t.right);
    }
}
