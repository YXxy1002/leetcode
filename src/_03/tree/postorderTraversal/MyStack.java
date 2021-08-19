package _03.tree.postorderTraversal;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xieyu
 * @since 2021/08/16 14:25
 */

public class MyStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode travelled = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 这里先peek,不出栈,因为要判断这个元素右边还需不需要遍历
            root = stack.peek();
            if (root.right != null && root.right != travelled) {
                // 说明右边还有需要遍历的,继续遍历右边
                root = root.right;
            } else {
                // 右边没有了,或者右边已经遍历完了,直接把当前节点加入res,然后标记为travelled
                root = stack.pop();
                res.add(root.val);
                travelled = root;
                root = null;
            }
        }
        return res;
    }
}