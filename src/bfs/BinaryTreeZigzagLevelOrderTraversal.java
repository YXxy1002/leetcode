package bfs;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * @author xieyu
 * @keywords: bfs 双端队列
 * @ideas: 正常方向offerLast  逆序的offerFirst 维护direction
 * @since 2021-7-6 21:24:57
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean direction = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (direction) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new ArrayList<>(list));
            direction = !direction;
        }
        return res;
    }
}
