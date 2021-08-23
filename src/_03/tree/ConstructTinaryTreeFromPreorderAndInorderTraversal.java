package _03.tree;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author xieyu
 * @keywords: DFS
 * @ideas: 同106
 * @since 2021-7-6 21:24:57
 */
public class ConstructTinaryTreeFromPreorderAndInorderTraversal {

    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int[] preorder;
    int currentNodeIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        this.preorder = preorder;
        return buildTree(0, inorder.length - 1);
    }


    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int currentNodeValue = preorder[currentNodeIndex];
        TreeNode node = new TreeNode(currentNodeValue);
        currentNodeIndex++;
        Integer inorderIndex = inorderMap.get(currentNodeValue);
        node.left = buildTree(left, inorderIndex - 1);
        node.right = buildTree(inorderIndex + 1, right);
        return node;
    }
}