package linkedList.ms;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * @author xieyu
 * @keywords: dfs
 * @ideas: 可以用栈  也可以让结点1先走到K位置,然后从头发出结点2,等结点1走到终点,这时候结点2就是倒数K个位置
 * @since 2021-7-8 15:41:50
 */
public class KthNodeFromEndOfListLcci {
    public int kthToLast(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int count = 0;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (++count == k) {
                return node.val;
            }
        }
        return 0;
    }
}
