package linkedList;

/**
 * 203. 移除链表元素
 *
 * @author xieyu
 * @keywords: dummy结点
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        dummy.next = head;
        // 为了判断条件node.next!=null所以要事先声明一个dummy结点来保证下一个肯定不是空号
        while (dummy.next != null) {
            if (dummy.next.val == val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return p.next;
    }
}
