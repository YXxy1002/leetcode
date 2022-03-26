package linkedList;

import java.util.Stack;

/**
 * 234. 回文链表
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        int total = 0;
        while (tmp != null) {
            total++;
            tmp = tmp.next;
        }
        Stack<ListNode> stack = new Stack<>();
        int push = total / 2;
        while (push > 0) {
            stack.push(head);
            head = head.next;
            push--;
        }
        if (total % 2 == 1) {
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
