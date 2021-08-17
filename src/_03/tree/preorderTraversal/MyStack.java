package _03.tree.preorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xieyu
 * @since 2021/08/16 14:25
 */

public class MyStack {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }
}