package linkedList;

/**
 * 反转链表
 *
 * @author xieyu
 * @keywords: 迭代 递归
 * @ideas: 迭代: 2个指针,遍历中改变2个节点的引用 递归:一直递归到最后一个节点
 * @since 2021-7-8 15:41:50
 */
public class ReverseLinkedList {
    public class ListNode {
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

    /**
     * 递归写法
     */
    public ListNode reverseList(ListNode head) {
        // 结束条件:没有下一个了(head==null为了处理空数组情况)
        if (head == null || head.next == null) {
            return head;
        }
        // 一直往下,直到找到最里面的节点
        ListNode next = reverseList(head.next);
        // 将当前节点的下一个指向自己,自己的下一个指向消除
        head.next.next = head;
        head.next = null;
        // 注意这里返回的还是最开始的头结点,一直没变
        return next;
    }

    /**
     * 迭代写法
     */
//    public ListNode reverseList(ListNode head) {
//        //2个指针,指向前驱和当前
//        ListNode pre = null;
//        ListNode cur = head;
//        // pre指向最后一个节点的时候循环结束
//        while (cur != null) {
//            // 先临时保存cur的下一个节点
//            ListNode next = cur.next;
//            cur.next = pre;
//            // 更新pre和cur
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
}