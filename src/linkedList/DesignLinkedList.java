package linkedList;

/**
 * 203. 移除链表元素
 *
 * @author xieyu
 * @keywords: dummy结点
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class DesignLinkedList {
    class MyLinkedList {

        private Node head;

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        public MyLinkedList() {

        }

        public int get(int index) {
            Node cur = head;
            while (cur != null && index > 0) {
                cur = cur.next;
                index--;
            }
            if (cur == null) {
                return -1;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
            } else {
                Node newHead = new Node(val);
                newHead.next = this.head;
                this.head = newHead;
            }
        }

        public void addAtTail(int val) {
            Node dummy = new Node(-1);
            dummy.next = head;
            while (dummy.next != null) {
                dummy = dummy.next;
            }
            dummy.next = new Node(val);
            if (head == null) {
                head = dummy.next;
            }
        }

        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                this.addAtHead(val);
            } else {
                // 找到index位置的前驱结点
                Node cur = head;
                while (cur != null && index > 1) {
                    cur = cur.next;
                    index--;
                }
                if (cur == null) {
                    return;
                }
                Node next = cur.next;
                cur.next = new Node(val);
                cur.next.next = next;
            }
        }

        public void deleteAtIndex(int index) {
            Node dummy = new Node(1);
            dummy.next = head;
            Node cur = dummy;
            while (cur != null && index > 0) {
                cur = cur.next;
                index--;
            }
            if (cur == null || cur.next == null) {
                return;
            }
            Node toDelete = cur.next;
            cur.next = toDelete.next;
            toDelete.next = null;
            if (index == 0) {
                head = dummy.next;
            }
        }
    }
}
