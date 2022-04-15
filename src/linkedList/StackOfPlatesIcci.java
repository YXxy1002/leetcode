package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 03.03. 堆盘子
 *
 * @author xieyu
 * @keywords: 数组+链表
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class StackOfPlatesIcci {

    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        print(head);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    private void print(ListNode head){
        if(head.next!=null){
            print(head.next);
        }
        list.add(head.val);
    }


    class StackOfPlates {
        List<MyStack> list;
        int cap;

        public StackOfPlates(int cap) {
            this.list = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (list.isEmpty()) {
                if (this.cap > 0) {
                    list.add(new MyStack(val));
                }
            } else {
                MyStack last = list.get(list.size() - 1);
                if (last.size >= this.cap) {
                    if (this.cap > 0) {
                        list.add(new MyStack(val));
                    }
                } else {
                    last.addNode(val);
                }
            }
        }

        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            return popFromList(list.size() - 1);
        }

        public int popAt(int index) {
            if (index >= list.size()) {
                return -1;
            }
            return popFromList(index);
        }

        private int popFromList(int index) {
            MyStack last = list.get(index);
            int res = last.removeHead();
            if (last.size <= 0) {
                list.remove(last);
            }
            return res;
        }

        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        class MyStack {
            Node head;
            int size = 0;

            public MyStack(int val) {
                this.head = new Node(val);
                this.size++;
            }

            public void addNode(int val) {
                if (this.head == null) {
                    this.head = new Node(val);
                } else {
                    Node tmp = head;
                    this.head = new Node(val);
                    this.head.next = tmp;
                }
                this.size++;
            }

            public int removeHead() {
                if (this.head == null) {
                    return -1;
                }
                int res = this.head.val;
                Node next = this.head.next;
                this.head.next = null;
                this.head = next;
                this.size--;
                return res;
            }
        }
    }
}
