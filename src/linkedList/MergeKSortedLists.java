package linkedList;

/**
 * 23. 合并K个升序链表
 *
 * @author xieyu
 * @keywords: 分治 合并2个有序链表
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (r < l) {
            return null;
        }
        if (r == l) {
            return lists[l];
        }
        int mid = (l + r) >> 1;
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    private ListNode mergeTwo(ListNode list1, ListNode list2) {
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
