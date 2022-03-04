package linkedList;

/**
 * 24. 两两交换链表中的节点
 *
 * @author xieyu
 * @keywords: 迭代
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 画个图看一下,想实现交换相邻2个元素有3个结点需要改变next,标好这3个结点然后进行交换,需要一个虚拟头结点作为第一个p
        ListNode p = new ListNode();
        p.next = head;
        ListNode tmp = head.next;
        ListNode n1 = head;
        ListNode n2 = head.next;
        while (n1 != null && n2 != null) {
            n1.next = n2.next;
            n2.next = n1;
            p.next = n2;
            p = n1;
            n1 = n1.next;
            if (n1 != null) {
                n2 = n1.next;
            }
        }
        return tmp;
    }
}