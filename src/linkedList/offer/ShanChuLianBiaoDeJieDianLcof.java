package linkedList.offer;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author xieyu
 * @keywords:
 * @ideas: 用哑结点来处理删除头结点的情况
 * @since 2021-7-8 15:41:50
 */
public class ShanChuLianBiaoDeJieDianLcof {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode tmp = dum;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        return dum.next;
    }
}
