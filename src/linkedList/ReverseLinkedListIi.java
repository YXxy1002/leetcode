package linkedList;

/**
 * 92. 反转链表 II
 *
 * @author xieyu
 * @keywords: 迭代
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class ReverseLinkedListIi {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tmp = head;
        // 需要的4个结点
        ListNode leftPre = null;
        ListNode rightNext = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        int cur = 1;
        while (cur <= right + 1 && tmp != null) {
            if (cur == left - 1) {
                leftPre = tmp;
            }
            if (cur == right + 1) {
                rightNext = tmp;
            }
            if (cur == left) {
                leftNode = tmp;
            }
            if (cur == right) {
                rightNode = tmp;
            }
            tmp = tmp.next;
            cur++;
        }
        // 翻转leftNode 到 rightNode
        ListNode p = null;
        ListNode n = leftNode;
        while (n != rightNext) {
            ListNode tmpNode = n.next;
            n.next = p;
            p = n;
            n = tmpNode;
        }
        // 改变leftPre和rightNext的一些位置
        leftNode.next = rightNext;
        if (leftPre != null) {
            leftPre.next = rightNode;
            return head;
        } else {
            return rightNode;
        }
    }
}
