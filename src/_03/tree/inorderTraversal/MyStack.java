package _03.tree.inorderTraversal;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xieyu
 * @since 2021/08/16 14:25
 */

public class MyStack {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 对于所有节点, 需要优先把所有左节点加入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 从stack取出元素,
            if (!stack.isEmpty()) {
                // 到这里说明左节点遍历到底了,可以输出了
                TreeNode pop = stack.pop();
                res.add(pop.val);
                // 这步很关键,接下来要对取出元素的右节点进行遍历
                root = pop.right;
            }
        }
        return res;
    }
}