package linkedList.ms;

import linkedList.ListNode;

/**
 * 面试题 02.08. 环路检测
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class LinkedListCycleLcci {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (fast != null && slow == fast) {
                // 相遇后从头结点和相遇结点各发出一个指针,再次相遇即为入环结点
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
