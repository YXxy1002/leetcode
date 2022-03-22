package linkedList;

/**
 * 143. 重排链表
 *
 * @author xieyu
 * @keywords: 反转链表 合并链表
 * @ideas:
 * @since 2022-3-22 10:44:23
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // 计算断裂位置
        ListNode tmp = head;
        int total = 0;
        while (tmp != null) {
            total++;
            tmp = tmp.next;
        }
        int breakIndex = total / 2 + 1;
        ListNode breakNode = head;
        while (breakIndex > 1) {
            breakNode = breakNode.next;
            breakIndex--;
        }
        ListNode breakNext = breakNode.next;
        if (breakNext == null) {
            return;
        }
        // 将中间处断开
        breakNode.next = null;
        // 反转breakNext之后的结点
        ListNode lastNode = reverse(breakNext);
        // 合并2个链表
        while (lastNode != null) {
            ListNode tmpNext = lastNode.next;
            ListNode next = head.next;
            head.next = lastNode;
            lastNode.next = next;
            head = next;
            lastNode = tmpNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode p = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = p;
            p = head;
            head = tmp;
        }
        return p;
    }
}
