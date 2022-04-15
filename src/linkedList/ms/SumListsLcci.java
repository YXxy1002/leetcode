package linkedList.ms;

import linkedList.ListNode;

/**
 * 面试题 02.05. 链表求和
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class SumListsLcci {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmpRes = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int total = num1 + num2 + carry;
            if (total >= 10) {
                total = total % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            tmpRes.next = new ListNode(total);
            tmpRes = tmpRes.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 进位如果唯一要额外多一个数字
        if (carry == 1) {
            tmpRes.next = new ListNode(1);
        }
        return res.next;
    }
}
