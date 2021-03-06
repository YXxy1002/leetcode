package _03.tree.inorderTraversal;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieyu
 * @since 2021/08/13 20:57
 */
public class Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(final TreeNode root, final List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}