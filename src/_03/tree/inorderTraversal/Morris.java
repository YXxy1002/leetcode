package _03.tree.inorderTraversal;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieyu
 * @since 2021/08/13 20:57
 */

public class Morris {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    res.add(cur.val);
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}