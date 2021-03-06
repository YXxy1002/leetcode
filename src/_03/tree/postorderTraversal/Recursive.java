package _03.tree.postorderTraversal;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieyu
 * @since 2021/08/13 20:57
 */
public class Recursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(final TreeNode root, final List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }
}