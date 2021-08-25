package _03.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class PopulatingNextRightPointersInEachNode {
//    public Node connect(Node root) {
//        if (root == null) {
//            return root;
//        }
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node poll = queue.poll();
//                if (i < size - 1) {
//                    poll.next = queue.peek();
//                }
//                if (poll.left != null) {
//                    queue.add(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.add(poll.right);
//                }
//            }
//        }
//        return root;
//    }

    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        Node left = node.left;
        Node right = node.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
