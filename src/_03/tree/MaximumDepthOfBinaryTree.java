package _03.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 1.DFS自顶向下
     */

/*    private int ans = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, ans + 1);
        return ans;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 当前节点为叶子节点的时候更新最大深度
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }*/


    /**
     * 2.DFS自底向上
     */
/*    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }*/


    /**
     * 3.BFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res++;
        }
        return res;
    }
}