package linkedList.ms;

import linkedList.ListNode;

import java.util.Stack;

/**
 * 面试题 02.04. 分割链表
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class PartitionListLcci {
    public ListNode partition(ListNode head, int x) {
        // 2个链表一个存>= 一个存<
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallTmp = small;
        ListNode largeTmp = large;
        while (head != null) {
            if (head.val >= x) {
                largeTmp.next = head;
                largeTmp = largeTmp.next;
            } else {
                smallTmp.next = head;
                smallTmp = smallTmp.next;
            }
            head = head.next;
        }
        // 注意将large的下一个元素置空否则可能出现环状链表
        largeTmp.next = null;
        // small接上large
        smallTmp.next = large.next;
        return small.next;
    }
}
