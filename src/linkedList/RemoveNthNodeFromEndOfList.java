package linkedList;

/**
 * 面试题 02.07. 链表相交
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 2个指针,先让右指针走到n的位置,然后一起移动,直到r到最后一个结点,然后删除l的下一个结点
        ListNode l = head;
        ListNode r = head;
        while (n > 0) {
            r = r.next;
            n--;
        }
        if (r == null) {
            return head.next;
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        // 删除l的后继节点
        l.next = l.next.next;
        return head;
    }
}
