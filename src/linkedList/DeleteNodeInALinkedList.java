package linkedList;

/**
 * 237. 删除链表中的节点
 *
 * @author xieyu
 * @keywords: 当前结点的值改成下个结点的值, 然后去掉下个结点
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
