package _03.tree.preorderTraversal;

import _03.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieyu
 * @since 2021/08/13 20:57
 */

public class Morris {
    public List<Integer> preorderTraversal(TreeNode root) {
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
                    res.add(cur.val);
                    cur = cur.left;
                } else {
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
                // 左边为空,打印当前节点,并开始遍历右边节点
//                printAndTravelRight();
            } else {
                // 1.找到左节点的最右节点
//                findMostRight();
                // 2.如果最右节点是空那就跟cur连起来,并打印cur,然后cur指向下一个
//                printWhenRightIsNull();
                // 3.如果cur不是空说明已经连起来了,证明左子树已经遍历完毕,这时候去掉这跟连线,将cur指向cur的右节点
//                removeLinkAndTravelNextRightWhenRightIsNotNull();
            }
        }
        return res;
    }

}