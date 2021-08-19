package _03.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class SymmetricTree {
    /**
     * 递归出口:
     * 1.两个节点都为null(到叶子节点了)
     * 2.两个节点不相等
     */
//    public boolean isSymmetric(TreeNode root) {
//        return isSymmetric(root, root);
//    }
//
//    private boolean isSymmetric(final TreeNode left, final TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null) {
//            return false;
//        }
//        if (left.val != right.val) {
//            return false;
//        }
//        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
//    }
    public static boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.push(left.right);
            queue.push(right.left);
            queue.push(left.left);
            queue.push(right.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.right = node3;
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        boolean symmetric = isSymmetric(node1);
        System.out.println(symmetric);
    }


}