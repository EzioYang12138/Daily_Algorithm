import java.util.*;

/**
 * Definition for a binary tree node.
 */

//https://leetcode-cn.com/problems/binary-tree-right-side-view/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class _4_22 {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.left);
                if (i == size - 1) res.add(node.val);
            }
        }

        return res;
    }
}
