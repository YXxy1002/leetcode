package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 225. 用队列实现栈
 *
 * @author xieyu
 * @keywords:
 * @ideas: 从队列取出元素再插入实现顺序转换
 * @since 2021-7-10 20:14:32
 */
public class ImplementStackUsingQueues {
}

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while (size-- > 1) {
            int num = queue.poll();
            queue.offer(num);
        }
        return queue.poll();
    }

    public int top() {
        int size = queue.size();
        while (size-- > 0) {
            int num = queue.poll();
            queue.offer(num);
            if (size == 0) {
                return num;
            }
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}