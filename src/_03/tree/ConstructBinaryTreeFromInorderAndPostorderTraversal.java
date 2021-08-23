package _03.tree;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author xieyu
 * @keywords: DFS
 * @ideas: 从后序遍历找到头结点, 然后从中序遍历中从头结点开始构建, 然后递归构建右子树和左子树
 * @since 2021-7-6 21:24:57
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int[] postorder;
    int currentNodeIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        this.postorder = postorder;
        // currentNodeIndex最初等于后续遍历的最后一个数(头结点)
        currentNodeIndex = postorder.length - 1;
        return buildTree(0, inorder.length - 1);
    }

    /**
     * 递归构造二叉树
     */
    private TreeNode buildTree(int left, int right) {
        // 退出条件:left>right
        if (left > right) {
            return null;
        }
        // 构建当前节点
        int currentNodeValue = postorder[currentNodeIndex];
        TreeNode node = new TreeNode(currentNodeValue);

        // 更新currentNodeIndex,这里可以画图看一下,后序遍历中最后一个节点是根节点,构建完这个节点后开始构建右子树,这时候右子树的根节点应该是currentNodeIndex的前一个节点,这也是下面要先构建右子树的原因
        currentNodeIndex--;

        // 找出中序遍历中这个节点的位置,然后递归构造右子树和左子树
        Integer inorderIndex = inorderMap.get(currentNodeValue);
        node.right = buildTree(inorderIndex + 1, right);
        node.left = buildTree(left, inorderIndex - 1);
        return node;
    }
}