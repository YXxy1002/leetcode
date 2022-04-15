package linkedList;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 *
 * @author xieyu
 * @keywords: 反转链表
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverse(l1);
        ListNode node2 = reverse(l2);
        ListNode res = new ListNode();
        ListNode tmp = res;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int num1 = node1 == null ? 0 : node1.val;
            int num2 = node2 == null ? 0 : node2.val;
            int total = num1 + num2 + carry;
            if (total >= 10) {
                total = total % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res.next = new ListNode(total);
            res = res.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (carry == 1) {
            res.next = new ListNode(1);
        }
        return reverse(tmp.next);
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
