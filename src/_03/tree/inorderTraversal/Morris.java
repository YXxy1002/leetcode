package _03.tree.inorderTraversal;

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


    public List<Integer> preorderTraversalTemplate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //首先把根节点赋值给cur
        TreeNode cur = root;
        //如果cur不为空就继续遍历
        while (cur != null) {
            if (cur.left == null) {
                // 右边为空,打印当前节点,并开始遍历右边节点
            } else {
                // 1.找到左节点的最右节点

                // 2.如果最右节点是空那就跟cur连起来,一直循环直到将所有mostRight和cur建立了连接
                // 3.如果cur不是空说明已经连起来了,证明左子树已经遍历完毕,这时候开始打印元素,并去掉这跟连线,将cur指向cur的右节点
            }
        }
        return res;
    }

}