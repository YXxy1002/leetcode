package linkedList;

/**
 * 148. 排序链表
 *
 * @author xieyu
 * @keywords: 归并排序
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中间点 这里的细节是fast要从第二个结点开始, 如果从第一个结点开始在只剩2个结点的时候会出现死循环
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开
        ListNode tmp = slow.next;
        slow.next = null;
        // 分别排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 合并有序链表
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                res.next = right;
                right = right.next;
            } else {
                res.next = left;
                left = left.next;
            }
            res = res.next;
        }
        res.next = left == null ? right : left;
        return tmp.next;
    }
}
