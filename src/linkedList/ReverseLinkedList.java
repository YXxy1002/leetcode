package linkedList;

/**
 * 206. 反转链表
 *
 * @author xieyu
 * @keywords: 迭代
 * @ideas: 需要声明一个空的前驱结点
 * @since 2021-7-8 15:41:50
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode n = head;
        while (n != null) {
            ListNode tmp = n.next;
            n.next = p;
            p = n;
            n = tmp;
        }
        return p;
    }
}