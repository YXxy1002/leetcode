package _03.tree;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * @author xieyu
 * @keywords: BFS
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            // 用一个循环保证当前层级优先遍历完
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.remove();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}