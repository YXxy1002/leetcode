package linkedList;

/**
 * 61. 旋转链表
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2022-3-21 11:45:57
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 计算总共结点
        int total = 0;
        ListNode tmp = head;
        ListNode tail = null;
        while (tmp != null) {
            total++;
            if (tmp.next == null) {
                tail = tmp;
            }
            tmp = tmp.next;
        }
        // 计算移动位置
        int rotate = k % total;
        if (rotate == 0) {
            return head;
        }
        // 链表断开重接
        int newTailIndex = total - rotate - 1;
        ListNode newTail = head;
        while (newTailIndex > 0) {
            newTail = newTail.next;
            newTailIndex--;
        }
        ListNode res = newTail.next;
        newTail.next = null;
        tail.next = head;
        return res;
    }
}
