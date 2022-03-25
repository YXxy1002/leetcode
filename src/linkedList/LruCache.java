package linkedList;

import java.util.HashMap;

/**
 * 146. LRU 缓存
 *
 * @author xieyu
 * @keywords: 1.node要存key和value便于找到node的时候根据key去移除map中的元素
 *            2.双向链表需要: 1)加在尾部 2)移除头部 3)移动到尾部
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class LruCache {
    private HashMap<Integer, Node> map;
    private DNode dNode;
    private int size;
    private int cap;

    public LruCache(int capacity) {
        map = new HashMap<>(capacity);
        dNode = new DNode();
        size = 0;
        cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        dNode.moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            dNode.moveToTail(node);
        } else {
            Node add = new Node(key, value);
            map.put(key, add);
            dNode.addTail(add);
            size++;
            if (size > cap) {
                Node removeNode = dNode.removeHead();
                map.remove(removeNode.key);
                size--;
            }
        }
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node pre;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DNode {
    private Node head;
    private Node tail;

    public DNode() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public void addTail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public Node removeHead() {
        Node next = head.next;
        if (next == tail) {
            return null;
        }
        removeNode(next);
        return next;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    public void moveToTail(Node node) {
        removeNode(node);
        addTail(node);
    }
}