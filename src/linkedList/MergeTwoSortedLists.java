package linkedList;

/**
 * 21. 合并两个有序链表
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        // 遍历2个链表
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        // 某个链表遍历完了直接将另一个链表加在末尾
        if (list1 == null) {
            dummy.next = list2;
        } else {
            dummy.next = list1;
        }
        return res.next;
    }
}
