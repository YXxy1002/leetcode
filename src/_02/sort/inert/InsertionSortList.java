package _02.sort.inert;

/**
 * 147. 对链表进行插入排序
 *
 * @author xieyu
 * @keywords: 插入排序
 * @ideas:
 * @since 2021/08/02 20:35:16
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

public class InsertionSortList {
    /**
     * v1
     * 和数组的插入排序一样,步骤应该是:
     * 1.从第二个节点开始遍历
     * 2.以当前节点再和之前所有节点进行比较
     * 3.找到一个合适的前驱节点插入
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        // 从第二个节点开始遍历
        ListNode cur = head.next;
        while (cur != null) {
            // 从链表头部开始遍历到cur前一个位置,找到插入的位置
            ListNode from = head;
            // 写到这里发现有个问题:如何判定cur前一个位置?
            while (from != null) {

            }
        }
        return head;
    }

    /**
     * v2
     * 在v1的基础上,维护一个end指向cur前一个位置
     * 开始end指向head,当cur比end打的时候end后移一位,否则cur会在end前找到一个位置插入,end不会改变
     * 有了end,就能做到对cur前面的数据进行遍历
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        // 从第二个节点开始遍历
        ListNode cur = head.next;
        // 维护一个end,指向cur的前一个元素,初始指向head
        ListNode end = head;
        while (cur != null) {
            // 如果cur比end还大,说明cur就是最后一个,直接改变end和cur就行
            if (cur.val > end.val) {
                end = end.next;
                cur = cur.next;
            } else {
                // 从head开始找到合适前驱节点插入,这里注意必须要找到前驱节点,找到后驱节点是没法进行插入的
                ListNode pre = head;
                while (pre.next.val > cur.val) {
                    pre = pre.next;
                    // 写到这里发现有2个问题 1:pre.next.val可能为空而导致NPE 2.假设cur比head还小就无法找到head的前驱节点
                }
            }
        }
        return head;
    }

    /**
     * v3
     * 在v2的基础上,维护一个哑结点dummy指向head,遍历从dummy开始,这样能解决找不到head前驱的问题
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 从第二个节点开始遍历
        ListNode cur = head.next;
        // 维护一个end,指向cur的前一个元素,初始指向head
        ListNode end = head;
        // 维护一个dummy放在head之前,值随便设置一个
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (cur != null) {
            // 如果cur比end还大,说明cur就是最后一个,直接改变end和cur就行
            if (cur.val > end.val) {
                end = end.next;
                cur = cur.next;
            } else {
                // 从dummy开始找到合适前驱节点插入,这里注意必须要找到前驱节点,找到后驱节点是没法进行插入的
                ListNode pre = dummy;
                // 当值比cur小的时候一直循环,找到更大的数为止
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                // 到这里说明找到需要插入的前驱节点了,进行插入
                end.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                // cur指向end下一个
                cur = end.next;
            }
        }
        return dummy.next;
    }
}