package linkedList;

/**
 * 141. 环形链表
 *
 * @author xieyu
 * @keywords: 快慢指针
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
