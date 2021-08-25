package _03.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }


    public TreeNode deserialize(String data) {
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String nodeVal = queue.poll();
        if ("N".equals(nodeVal)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        SerializeAndDeserializeBinaryTree a = new SerializeAndDeserializeBinaryTree();
//        String serialize = a.serialize(node1);
//        System.out.println(serialize);
        SerializeAndDeserializeBinaryTree a = new SerializeAndDeserializeBinaryTree();
        String serialize = a.serialize(null);
        TreeNode deserialize = a.deserialize(serialize);
        System.out.println(111);

    }
}
