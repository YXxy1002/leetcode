package linkedList.offer;

/**
 * 剑指 Offer II 028. 展平多级双向链表
 *
 * @author xieyu
 * @keywords: 反转链表
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class Qv1Da2 {
    static Node res;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.prev = node1;
        node1.child = node3;

        Node flatten = flatten(node1);
        System.out.println(111);
    }

    public static Node flatten(Node head) {
        res = new Node();
        Node tmp = res;
        traver(head);
        return tmp.next;
    }

    private static void traver(Node node) {
        if (node == null) {
            return;
        }
        // 连接当前结点
        res.next = node;
        node.prev = res;

        res = res.next;
        // 视情况递归下一个结点
        if (node.child == null) {
            traver(node.next);
        } else {
            Node next = node.next;
            traver(node.child);
            if (next != null) {
                traver(next);
            }
        }

    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    ;
}
