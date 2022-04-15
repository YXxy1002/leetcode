package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 142. 环形链表 II
 *
 * @author xieyu
 * @keywords: https://www.programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#_142-%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8ii
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class LinkedListCycleIi {


    public ListNode detectCycle(ListNode head) {
        List<ListNode> res = new ArrayList<>();
        ListNode[] listNodes = res.toArray(new ListNode[]{});

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                // 相遇后从相遇结点发出一个指针,从head发出一个指针,两个指针相遇结点就是入环结点
                ListNode n1 = fast;
                ListNode n2 = head;
                while (n1 != null) {
                    if (n1 == n2) {
                        return n1;
                    }
                    n1 = n1.next;
                    n2 = n2.next;
                }
            }
        }
        return null;
    }
}
